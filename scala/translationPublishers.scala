package translator

import swing._
import swing.BorderPanel.Position._
import event._
import java.awt.{ Color, Graphics2D }
import scala.util.Random


class TranslationPublishers {
/*
  val katakanaTranslation = new TextField
  val hiraganaTranslation = new TextField
  val romajiTranslation = new TextField

  val kanjiTranslation = new TextField

  val englishTranslation = new TextField


 */
  val katakanaTranslation = new TextArea
  val hiraganaTranslation = new TextArea
  val romajiTranslation = new TextArea

  val kanjiTranslation = new TextArea

  val englishTranslation = new TextArea


  val katakanaTranslateButton = new Button {
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

  val kanjiTranslateButton = new Button {
    text = "Translate Kanji"
    borderPainted = true
    enabled = true
  }

  val englishTranslateButton = new Button {
    text = "Translate English"
    borderPainted = true
    enabled = true
  }

  val clearTranslationButton = new Button {
    text = "Clear Translation Fields"
    borderPainted = true
    enabled = true
  }



}
