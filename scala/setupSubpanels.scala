package translator

import swing._
import swing.BorderPanel.Position._
import event._
import java.awt.{ Color, Graphics2D }
import scala.util.Random

class SetupSubpanels (pub: SetupPublishers) {

    // Japanese Katakana panel
    val katakanaSetupPanel = new BorderPanel {

      layout(new Label {
        text = "Katakana"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }) = North
      
      layout(pub.katakanaSetup) = Center
      //layout(pub.katakanaTranslateButton) = South
    }
    // Japanese Hiragana panel
    val hiraganaSetupPanel = new BorderPanel {

      layout(new Label {
        text = "Hiragana"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }) = North
      
      layout(pub.hiraganaSetup) = Center
      //layout(pub.hiraganaTranslateButton) = South
    }
    // Japanese Romaji panel
    val romajiSetupPanel = new BorderPanel {

      layout(new Label {
        text = "Romaji"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }) = North
      
      layout(pub.romajiSetup) = Center
      //layout(pub.romajiTranslateButton) = South
    }
    // Japanese Kangi panel
    val kangiSetupPanel = new BorderPanel {

      layout(new Label {
        text = "Kangi"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }) = North
      
      layout(pub.kangiSetup) = Center
      //layout(pub.kangiTranslateButton) = South
    }

    // English panel
    val englishSetupPanel = new BorderPanel {
      layout(new Label {
        text = "English"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }) = North
      layout(pub.englishSetup) = Center
      //layout(pub.englishTranslateButton) = South
    }

}


