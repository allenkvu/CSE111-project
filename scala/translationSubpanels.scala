package translator

import swing._
import swing.BorderPanel.Position._
import event._
import java.awt.{ Color, Graphics2D }
import scala.util.Random

class TranslationSubpanels (pub: TranslationPublishers) {

    // Japanese Katakana panel
    val katakanaTranslationPanel = new BorderPanel {

      layout(new Label {
        text = "Katakana"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }) = North
      
      layout(pub.katakanaTranslation) = Center
      layout(pub.katakanaTranslateButton) = South
    }
    // Japanese Hiragana panel
    val hiraganaTranslationPanel = new BorderPanel {

      layout(new Label {
        text = "Hiragana"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }) = North
      
      layout(pub.hiraganaTranslation) = Center
      layout(pub.hiraganaTranslateButton) = South
    }
    // Japanese Romaji panel
    val romajiTranslationPanel = new BorderPanel {

      layout(new Label {
        text = "Romaji"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }) = North
      
      layout(pub.romajiTranslation) = Center
      layout(pub.romajiTranslateButton) = South
    }
    // Japanese Kangi panel
    val kangiTranslationPanel = new BorderPanel {

      layout(new Label {
        text = "Kangi"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }) = North
      
      layout(pub.kangiTranslation) = Center
      layout(pub.kangiTranslateButton) = South
    }

    // English panel
    val englishTranslationPanel = new BorderPanel {
      layout(new Label {
        text = "English"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }) = North
      layout(pub.englishTranslation) = Center
      layout(pub.englishTranslateButton) = South
    }

}


