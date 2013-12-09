package translator

import swing._
import swing.BorderPanel.Position._
import event._
import java.awt.{ Color, Graphics2D }
import scala.util.Random

object SimpleGUI extends SimpleSwingApplication {

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


    // buttons and text boxes -- translation

    val exitButton = new Button {
      text = "Exit"
      borderPainted = true
      enabled = true
    }

    val japaneseTranslation = new TextArea(5, 25) /*{
      setAlignmentX = Component.*/
    val englishTranslation = new TextArea(5,25)

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
      contents += japaneseTranslation

      // English
      contents += new Label {
        text = "English"
        font = new Font("ariel", java.awt.Font.PLAIN, 10)
      }
      contents += englishTranslation

      contents += exitButton

    }



    contents = new GridPanel (1, 2) {
      //border = Swing.EmptyBorder(40)
      //border = javax.swing.border.LineBorder(Color.black)
      contents += setupPanel
      contents += translationPanel


    }

    listenTo(exitButton)

    reactions += {
      case ButtonClicked(component) if component == exitButton =>
        //dispose()
        sys.exit(0)

      case EditDone(`japaneseTranslation`) =>
        print("Japanese input")

      case EditDone(`englishTranslation`) =>
        print("English input")

    }


  }
}
