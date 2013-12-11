package translator

import swing._
import swing.BorderPanel.Position._
import event._
import java.awt.{ Color, Graphics2D }
import scala.util.Random

object SimpleGUI extends SimpleSwingApplication {

  val myConnClass = new DBConn
  val conn = myConnClass.getConn
  val stat = myConnClass.getStat

  def top = new MainFrame {
    title = "Japanese-English Translator"
    menuBar = new MenuBar {
      contents += new Menu("File") {
        contents += new MenuItem(Action("Exit") {
          //sys.exit(0)
          conn.close()
          dispose()
        })
      }
    }


    val mySetupPublishers = new SetupPublishers
    val mySetupSubpanels = new SetupSubpanels(mySetupPublishers)

    val myTranslationPublishers = new TranslationPublishers
    val myTranslationSubpanels = new TranslationSubpanels(myTranslationPublishers)

    // panels of parent frame

    val setupPanel = new BoxPanel (Orientation.Vertical) {
      // 'setup' title
      contents += new Label {
        text = "Setupadsfasdf"
        font = new Font("Ariel", java.awt.Font.PLAIN, 20)
      }
      contents += mySetupSubpanels.katakanaSetupPanel
      contents += mySetupSubpanels.hiraganaSetupPanel
      contents += mySetupSubpanels.romajiSetupPanel
      contents += mySetupSubpanels.kangiSetupPanel

      contents += mySetupSubpanels.englishSetupPanel

      contents += mySetupPublishers.setupButton
      
      contents += mySetupPublishers.clearSetupButton

    }

    // Translation Panel
    val translationPanel = new BoxPanel (Orientation.Vertical) {
      contents += new Label {
        text = "Translation"
        font = new Font("Ariel", java.awt.Font.PLAIN, 20)
        horizontalAlignment = Alignment.Center
      }

      contents += myTranslationSubpanels.katakanaTranslationPanel
      contents += myTranslationSubpanels.hiraganaTranslationPanel
      contents += myTranslationSubpanels.romajiTranslationPanel
      contents += myTranslationSubpanels.kangiTranslationPanel

      contents += myTranslationSubpanels.englishTranslationPanel

      //contents += myTranslationPublishers.exitButton
      contents += myTranslationPublishers.clearTranslationButton

    }



    contents = new GridPanel (1, 2) {
      //border = Swing.EmptyBorder(40)
      //border = javax.swing.border.LineBorder(Color.black)
      contents += setupPanel
      contents += translationPanel


    }

    //listenTo(this.ke)

    listenTo(mySetupPublishers.setupButton)
    listenTo(mySetupPublishers.clearSetupButton)

    listenTo(myTranslationPublishers.clearTranslationButton)
    listenTo(myTranslationPublishers.katakanaTranslation,
      myTranslationPublishers.englishTranslation)
    listenTo(myTranslationPublishers.katakanaTranslateButton,
      myTranslationPublishers.englishTranslateButton)

    // REACTIONS
    reactions += {
      case KeyPressed(_, Key.Escape, _, _) => {
        conn.close()
        dispose()
      }
      // clear setup
      case ButtonClicked(component) if component ==
          mySetupPublishers.clearSetupButton =>
        clearSetup(mySetupPublishers)

        // SETUP
        // setup link between all 5 types
      case ButtonClicked(component)
          if ((component == mySetupPublishers.setupButton)
            && (mySetupPublishers.katakanaSetup.text != "")
            && (mySetupPublishers.hiraganaSetup.text != "")
            && (mySetupPublishers.romajiSetup.text != "")
            && (mySetupPublishers.kangiSetup.text != "")
            && (mySetupPublishers.englishSetup.text != "")
          ) => {
           val wordClasses = DBTools.parseEnglishSetup(conn, mySetupPublishers.englishSetup.text)
          }

      // setup link between English and Kana
      case ButtonClicked(component)
          if ((component == mySetupPublishers.setupButton)
            && (mySetupPublishers.katakanaSetup.text != "")
            && (mySetupPublishers.hiraganaSetup.text != "")
            && (mySetupPublishers.romajiSetup.text != "")
            && (mySetupPublishers.englishSetup.text != "")
          ) => {
           val wordClasses = DBTools.parseEnglishSetup(conn, mySetupPublishers.englishSetup.text)
          }

      // setup insert English
      case ButtonClicked(component)
          if ((component == mySetupPublishers.setupButton)
            && (mySetupPublishers.katakanaSetup.text != "")
            && (mySetupPublishers.hiraganaSetup.text != "")
            && (mySetupPublishers.romajiSetup.text != "")
            && (mySetupPublishers.englishSetup.text != "")
          ) => {
           val wordClasses = DBTools.parseEnglishSetup(conn, mySetupPublishers.englishSetup.text)
          }

      // setup insert Kana
      case ButtonClicked(component)
          if ((component == mySetupPublishers.setupButton)
            && (mySetupPublishers.katakanaSetup.text != "")
            && (mySetupPublishers.hiraganaSetup.text != "")
            && (mySetupPublishers.romajiSetup.text != "")
            && (mySetupPublishers.englishSetup.text != "")
          ) => {
           val wordClasses = DBTools.parseEnglishSetup(conn, mySetupPublishers.englishSetup.text)
          }



      // clear translation
      case ButtonClicked(component) if component ==
          myTranslationPublishers.clearTranslationButton =>
        clearTranslation(myTranslationPublishers)
      // translate katakana button
      case ButtonClicked(component) if component ==
          myTranslationPublishers.katakanaTranslateButton => {
            //println("click")
            myTranslationPublishers.englishTranslation.text = ""
            val ew = DBQueries.getEnglishWords(conn)
            //println("got")
            
            //for(w <- ew){
             // pw.englishWord)
              //myTranslationPublishers.englishTranslation.text += w.englishWord
            //}
            myTranslationPublishers.englishTranslation.text =
              ew.foldLeft("")((a: String,b: DBTypes.EnglishWord) => a+b.englishWord+"\n")

          }


          //"from db: " + DBTools.getEnglish(myConn)
        


      // translate english button
      case ButtonClicked(component) if component ==
          myTranslationPublishers.englishTranslateButton =>
        //DBTools.newRegion(conn, 101, myTranslationPublishers.englishTranslation.text)
        myTranslationPublishers.katakanaTranslation.text = "bar"



    }

  }


  def clearSetup(mySetupPublishers: SetupPublishers) = {
    mySetupPublishers.katakanaSetup.text = ""
    mySetupPublishers.hiraganaSetup.text = ""
    mySetupPublishers.romajiSetup.text = ""
    mySetupPublishers.kangiSetup.text = ""
    mySetupPublishers.englishSetup.text = ""
  }
  def clearTranslation(myTranslationPublishers: TranslationPublishers) = {
    myTranslationPublishers.katakanaTranslation.text = ""
    myTranslationPublishers.hiraganaTranslation.text = ""
    myTranslationPublishers.romajiTranslation.text = ""
    myTranslationPublishers.kangiTranslation.text = ""
    myTranslationPublishers.englishTranslation.text = ""
  }





}
