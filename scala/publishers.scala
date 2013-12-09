package translator

import swing._
import swing.BorderPanel.Position._
import event._
import java.awt.{ Color, Graphics2D }
import scala.util.Random


class publishers {
    val exitButton = new Button {
      text = "Exit"
      borderPainted = true
      enabled = true
    }

    val japaneseTranslation = new TextArea(5, 25) {
      

    }
    val japaneseTranslateButton = new Button {
      text = "Translate Japanese"
      borderPainted = true
      enabled = true
    }
    val englishTranslation = new TextArea(5,25)
    val englishTranslateButton = new Button {
      text = "Translate English"
      borderPainted = true
      enabled = true
    }


}
