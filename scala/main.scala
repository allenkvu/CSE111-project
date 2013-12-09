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
          sys.exit(0)
        })
      }
    }


    // buttons and text boxes -- setup

    val myPublishers = new publishers

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


      // Japanese
      contents += new Label {
        text = "Japanese"
        font = new Font("ariel", java.awt.Font.PLAIN, 10)
      }
      
      /*contents += new TextField ("Japanese") {
        editable = false
      }*/
      contents += myPublishers.japaneseTranslation
      contents += myPublishers.japaneseTranslateButton

      // English
      contents += new Label {
        text = "English"
        font = new Font("ariel", java.awt.Font.PLAIN, 10)
      }
      contents += myPublishers.englishTranslation
      contents += myPublishers.englishTranslateButton

      contents += myPublishers.exitButton

    }



    contents = new GridPanel (1, 2) {
      //border = Swing.EmptyBorder(40)
      //border = javax.swing.border.LineBorder(Color.black)
      contents += setupPanel
      contents += translationPanel


    }

    listenTo(myPublishers.exitButton)
    listenTo(myPublishers.japaneseTranslation, myPublishers.englishTranslation)
    listenTo(myPublishers.japaneseTranslateButton, myPublishers.englishTranslateButton)

    reactions += {
      case ButtonClicked(component) if component == myPublishers.exitButton =>
        //dispose()
        sys.exit(0)

      /*case EditDone(`japaneseTranslation`) =>
        englishTranslation.text = dbTools.getEnglish(myConn)

      case EditDone(`englishTranslation`) =>
        print("English input")
       */

      case ButtonClicked(component) if component == myPublishers.japaneseTranslateButton =>
        //englishTranslation.text = japaneseTranslation.text
        myPublishers.englishTranslation.text = myPublishers.japaneseTranslation.text + dbTools.getEnglish(myConn)


      case ButtonClicked(component) if component == myPublishers.englishTranslateButton =>
        myPublishers.japaneseTranslation.text = myPublishers.englishTranslation.text



    }


  }
}
