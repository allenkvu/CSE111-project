package translator

import swing._
import swing.BorderPanel.Position._
import event._
import java.awt.{ Color, Graphics2D }
import scala.util.Random

object SimpleGUI extends SimpleSwingApplication {

  val myConn = new dbConn

  def top = new MainFrame {
    title = "Japanese-English Translator"
    menuBar = new MenuBar {
      contents += new Menu("File") {
        contents += new MenuItem(Action("Exit") {
          //sys.exit(0)
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
        text = "Setup"
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

    listenTo(mySetupPublishers.setupButton)
    listenTo(mySetupPublishers.clearSetupButton)

    listenTo(myTranslationPublishers.clearTranslationButton)
    listenTo(myTranslationPublishers.katakanaTranslation, 
      myTranslationPublishers.englishTranslation)
    listenTo(myTranslationPublishers.katakanaTranslateButton,
      myTranslationPublishers.englishTranslateButton)

    reactions += {
      case ButtonClicked(component) if component ==
          mySetupPublishers.clearSetupButton =>
        mySetupPublishers.katakanaSetup.text = ""
        mySetupPublishers.hiraganaSetup.text = ""
        mySetupPublishers.romajiSetup.text = ""
        mySetupPublishers.kangiSetup.text = ""
        mySetupPublishers.englishSetup.text = ""

      case ButtonClicked(component) if component ==
          myTranslationPublishers.clearTranslationButton =>
        myTranslationPublishers.katakanaTranslation.text = ""
        myTranslationPublishers.hiraganaTranslation.text = ""
        myTranslationPublishers.romajiTranslation.text = ""
        myTranslationPublishers.kangiTranslation.text = ""
        myTranslationPublishers.englishTranslation.text = ""


      case ButtonClicked(component) if component ==
          myTranslationPublishers.katakanaTranslateButton =>
        //englishTranslation.text = japaneseTranslation.text
        myTranslationPublishers.englishTranslation.text =
          "from db: " + dbTools.getEnglish(myConn)


      case ButtonClicked(component) if component ==
          myTranslationPublishers.englishTranslateButton =>
        myTranslationPublishers.katakanaTranslation.text =
          myTranslationPublishers.englishTranslation.text



    }


  }
}
