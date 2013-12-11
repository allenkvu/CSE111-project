package translator

import swing._
import swing.BorderPanel.Position._
import event._
import java.awt.{ Color, Graphics2D }
import scala.util.Random

import java.sql.Connection

object SimpleGUI extends SimpleSwingApplication {

  val myDBInterface = new DBInterface
  val myConn = myDBInterface.getConn
  //  val stat = myDBInterface.getStat

  def top = new MainFrame {
    title = "Japanese-English Translator"
    menuBar = new MenuBar {
      contents += new Menu("File") {
        contents += new MenuItem(Action("Exit") {
          //sys.exit(0)
          myConn.close()
          dispose()
        })
      }
    }


    val myCountPanel = new CountPanel

    val mySetupPublishers = new SetupPublishers
    val mySetupSubpanels = new SetupSubpanels(mySetupPublishers)

    val myTranslationPublishers = new TranslationPublishers
    val myTranslationSubpanels = new TranslationSubpanels(myTranslationPublishers)

    // panels of parent frame



    val setupPanel = new BoxPanel (Orientation.Vertical) {
      // 'setup' title
      contents += new Label {
        text = "Setup"
        font = new Font("Ariel", java.awt.Font.PLAIN, 20)
      }
      contents += mySetupSubpanels.katakanaSetupPanel
      contents += mySetupSubpanels.hiraganaSetupPanel
      contents += mySetupSubpanels.romajiSetupPanel
      contents += mySetupSubpanels.kanjiSetupPanel


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
      contents += myTranslationSubpanels.kanjiTranslationPanel

      contents += myTranslationSubpanels.englishTranslationPanel

      //contents += myTranslationPublishers.exitButton
      contents += myTranslationPublishers.clearTranslationButton

    }



    contents = new GridPanel (1, 2) {
      //border = Swing.EmptyBorder(40)
      //border = javax.swing.border.LineBorder(Color.black)
      contents += setupPanel
      contents += translationPanel
      contents += myCountPanel.countPanel


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
        myConn.close()
        dispose()
      }
      // clear setup
      case ButtonClicked(component) if component ==
          mySetupPublishers.clearSetupButton =>
        clearSetup(mySetupPublishers)
        updateCountText(myConn, myCountPanel)

      // SETUP
      // setup link between all 5 types
      case ButtonClicked(component)
          if ((component == mySetupPublishers.setupButton)
            && (mySetupPublishers.katakanaSetup.text != "")
            && (mySetupPublishers.hiraganaSetup.text != "")
            && (mySetupPublishers.romajiSetup.text != "")
            && (mySetupPublishers.kanjiSetup.text != "")
            && (mySetupPublishers.englishSetup.text != "")
          ) =>
        val wordClasses = DBTools.parseEnglish(myConn, mySetupPublishers.englishSetup.text)
        updateCountText(myConn, myCountPanel)

      // setup link between English and Kana
      case ButtonClicked(component)
          if ((component == mySetupPublishers.setupButton)
            && (
              (mySetupPublishers.katakanaSetup.text != "")
                || (mySetupPublishers.hiraganaSetup.text != "")
                || (mySetupPublishers.romajiSetup.text != "")
            )
            && (mySetupPublishers.kanjiSetup.text == "")
            && (mySetupPublishers.englishSetup.text != "")
          ) =>
        val wordClasses = DBTools.parseEnglish(myConn, mySetupPublishers.englishSetup.text)
        updateCountText(myConn, myCountPanel)

      // setup insert English
      case ButtonClicked(component)
          if ((component == mySetupPublishers.setupButton)
            && (mySetupPublishers.katakanaSetup.text != "")
            && (mySetupPublishers.hiraganaSetup.text != "")
            && (mySetupPublishers.romajiSetup.text != "")
            && (mySetupPublishers.kanjiSetup.text == "")
            && (mySetupPublishers.englishSetup.text != "")
          ) =>
        val wordClasses = DBTools.parseEnglish(myConn, mySetupPublishers.englishSetup.text)
        updateCountText(myConn, myCountPanel)

      // setup insert Kanji
      case ButtonClicked(component)
          if ((component == mySetupPublishers.setupButton)
            && (mySetupPublishers.katakanaSetup.text == "")
            && (mySetupPublishers.hiraganaSetup.text == "")
            && (mySetupPublishers.romajiSetup.text == "")
            && (mySetupPublishers.kanjiSetup.text != "")
            && (mySetupPublishers.englishSetup.text == "")
          ) =>
        val wordClasses = DBTools.parseKanji(myConn, mySetupPublishers.englishSetup.text)
        updateCountText(myConn, myCountPanel)

        /*      // setup insert Kana
         case ButtonClicked(component)
         if ((component == mySetupPublishers.setupButton)
         && (mySetupPublishers.katakanaSetup.text != "")
         && (mySetupPublishers.hiraganaSetup.text != "")
         && (mySetupPublishers.romajiSetup.text != "")
         && (mySetupPublishers.kanjiSetup.text == "")
         && (mySetupPublishers.englishSetup.text != "")
         ) =>
         val wordClasses = DBTools.parseEnglishSetup(myConn, mySetupPublishers.englishSetup.text)
         updateCountText(myConn, myCountPanel)
         */



      // clear translation
      case ButtonClicked(component) if component ==
          myTranslationPublishers.clearTranslationButton =>
        clearTranslation(myTranslationPublishers)
        updateCountText(myConn, myCountPanel)
      // translate katakana button
      case ButtonClicked(component) if component ==
          myTranslationPublishers.katakanaTranslateButton => {
            //println("click")
            /*            myTranslationPublishers.englishTranslation.text = ""
             val ew = DBQueries.getEnglishWords(myConn)
             myTranslationPublishers.englishTranslation.text =
             ew.foldLeft("")((a: String,b: DBTypes.EnglishWord) => a+b.englishWord+"\n")*/

          }


        //"from db: " + DBTools.getEnglish(myMyConn)
        


      // translate english button
      case ButtonClicked(component) if component ==
          myTranslationPublishers.englishTranslateButton =>
        //DBTools.newRegion(myConn, 101, myTranslationPublishers.englishTranslation.text)
        myTranslationPublishers.katakanaTranslation.text = "bar"

    }

  }

  def updateCountText(conn: Connection, panel: CountPanel) = {
    val kanac = DBQueries.kanaWordCount(conn)
    panel.countPanel.kanaCount.text = kanac.toString
    val kanjic = DBQueries.kanjiWordCount(conn)
    panel.countPanel.kanjiCount.text = kanjic.toString
    val japanesec = DBQueries.japaneseWordCount(conn)
    panel.countPanel.japaneseCount.text = japanesec.toString
    val englishc = DBQueries.englishWordCount(conn)
    panel.countPanel.englishCount.text = englishc.toString
  }



  def clearSetup(mySetupPublishers: SetupPublishers) = {
    mySetupPublishers.katakanaSetup.text = ""
    mySetupPublishers.hiraganaSetup.text = ""
    mySetupPublishers.romajiSetup.text = ""
    mySetupPublishers.kanjiSetup.text = ""
    mySetupPublishers.englishSetup.text = ""
  }
  def clearTranslation(myTranslationPublishers: TranslationPublishers) = {
    myTranslationPublishers.katakanaTranslation.text = ""
    myTranslationPublishers.hiraganaTranslation.text = ""
    myTranslationPublishers.romajiTranslation.text = ""
    myTranslationPublishers.kanjiTranslation.text = ""
    myTranslationPublishers.englishTranslation.text = ""
  }





}
