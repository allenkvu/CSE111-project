package translator

import swing._
import swing.BorderPanel.Position._
import event._
import java.awt.{ Color, Graphics2D }
import scala.util.Random


class SetupPublishers {
/*
  val katakanaSetup = new TextField
  val hiraganaSetup = new TextField
  val romajiSetup = new TextField

  val kangiSetup = new TextField

  val englishSetup = new TextField
 */
  val katakanaSetup = new TextArea
  val hiraganaSetup = new TextArea
  val romajiSetup = new TextArea

  val kangiSetup = new TextArea

  val englishSetup = new TextArea


/*  val katakanaTranslateButton = new Button {
    text = "Translate Katakana"
    borderPainted = true
    enabled = true
  }
  val hiraganaTranslateButton = new Button {
    text = "Translate Hiragana"
    borderPainted = true
    enabled = true
  }
  val romajiTranslateButton = new Button {
    text = "Translate Romaji"
    borderPainted = true
    enabled = true
  }

  val kangiTranslateButton = new Button {
    text = "Translate Kangi"
    borderPainted = true
    enabled = true
  }
 
  val englishTranslateButton = new Button {
    text = "Translate English"
    borderPainted = true
    enabled = true
  }
 */

  val setupButton = new Button {
    text = "Enter filled fields into DB"
    borderPainted = true
    enabled = true
  }

  val clearSetupButton = new Button {
    text = "Clear Setup Fields"
    borderPainted = true
    enabled = true
  }



}
