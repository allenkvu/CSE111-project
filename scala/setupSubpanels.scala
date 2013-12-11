package translator

import swing._
import swing.BorderPanel.Position._
import event._
import java.awt.{ Color, Graphics2D }
import scala.util.Random

class CountPanel {
  val countPanel = new BoxPanel (Orientation.Vertical) {
    val kanaCount = new TextField {
      editable = false
    }
    val kanaCountPanel = new BorderPanel {
      layout(new Label {
        text = "Kana count"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }
      ) = North
      layout(kanaCount) = Center
    }
    val kanjiCount = new TextField {
      editable = false
    }
    val kanjiCountPanel = new BorderPanel {
      layout(new Label {
        text = "Kanji count"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }
      ) = North
      layout(kanjiCount) = Center
    }

    val japaneseCount = new TextField {
      editable = false
    }
    val japaneseCountPanel = new BorderPanel {
      layout(new Label {
        text = "Japanese word count"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }
      ) = North
      layout(japaneseCount) = Center
    }

    val englishCount = new TextField {
      editable = false
    }
    val englishCountPanel = new BorderPanel {
      layout(new Label {
        text = "English word count"
        font = new Font("ariel", java.awt.Font.PLAIN, 14)
      }
      ) = North
      layout(englishCount) = Center
    }

    contents += new Label {
      text = "Table Counts"
      font = new Font("Ariel", java.awt.Font.PLAIN, 20)
    }
    contents += kanaCountPanel
    contents += kanjiCountPanel
    contents += japaneseCountPanel
    contents += englishCountPanel


  }
}


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


