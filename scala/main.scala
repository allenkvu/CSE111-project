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


    // buttons and text boxes -- setup

    val myTranslationPublishers = new TranslationPublishers
    val myTranslationSubpanels = new TranslationSubpanels(myTranslationPublishers)




    // panels of parent frame

    val setupPanel = new FlowPanel {
      // 'setup' title
      contents += new Label {
        text = "Setup"
        font = new Font("Ariel", java.awt.Font.PLAIN, 20)
      }
      // setup interface
      //contents +=
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

    //listenTo(myTranslationPublishers.exitButton)
    listenTo(myTranslationPublishers.clearTranslationButton)
    listenTo(myTranslationPublishers.katakanaTranslation, 
      myTranslationPublishers.englishTranslation)
    listenTo(myTranslationPublishers.katakanaTranslateButton,
      myTranslationPublishers.englishTranslateButton)

    reactions += {
      /*case ButtonClicked(component) if component == myTranslationPublishers.exitButton =>
        //sys.exit(0)
        dispose()*/
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
          myTranslationPublishers.katakanaTranslation.text + dbTools.getEnglish(myConn)


      case ButtonClicked(component) if component ==
          myTranslationPublishers.englishTranslateButton =>
        myTranslationPublishers.katakanaTranslation.text =
          myTranslationPublishers.englishTranslation.text



    }


  }
}
