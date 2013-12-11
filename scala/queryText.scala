package translator

object QueryText {

  val getAllEnglish = """select * from englishWord;"""
  val getEnglish = """select * from englishWord where ew_word = ?;"""
  val englishCount = """select count(*) from englishWord;"""
  val englishExists = """select count(*) from englishWord where ew_word = ?;"""

  val getAllKana = """select * from kanaSystem;"""
  val getHiragana = """select * from kanaSystem where kns_hiragana = ?;"""
  val getKatakana = """select * from kanaSystem where kns_katakana = ?;"""
  val getRomaji = """select * from kanaSystem where kns_romaji = ?;"""
  val katakanaExists = """select count(*) from kanaSystem
where kns_katakana = ?;"""
  val hiraganaExists = """select count(*) from kanaSystem
where kns_hiragana = ?;"""
  val romajiExists = """select count(*) from kanaSystem
where kns_romaji = ?;"""
  val getKana = """select * from kanaSystem
where kns_hiragana = ? or kns_katakana = ? or kns_romaji = ?;"""



  val kanaCount = """select count(*) from kanaSystem;"""
  val kanaExists = """select count(*) from kanaSystem
where kns_hiragana = ? or kns_katakana = ? or kns_romaji = ?;"""

  val getKanji = """select * from kanjiSystem where ks_char = ?;"""
  val kanjiCount = """select count(*) from kanjiSystem;"""
  val kanjiExists = """select count(*) from kanjiSystem where ks_char = ?;"""


  val japaneseCount = """select count(*) from japaneseWord;"""

  val japaneseEnglishLinkCount = """select count(*) from japaneseEnglishWordLinkIndex;"""


  val getAllHiragana = """select kns_hiragana from kanaSystem;"""
  val getAllKatakana = """select kns_katakana from kanaSystem;"""
  val getAllRomaji = """select kns_romaji from kanaSystem;"""
  val getAllKangi = """select * from kangiSystem;"""

  val getKanaFromEnglishWord = """
SELECT kns_hiragana, kns_katakana, kns_romaji
FROM kanaSystem
INNER JOIN japaneseWordKanaLink
INNER JOIN japaneseEnglishWordLink
ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID
AND japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID
WHERE japaneseEnglishWordLink.jewl_englishWordID = (
      select ew_wordID from englishWord where ew_word = ?
)
ORDER BY japaneseWordKanaLink.jwkn_kanaOrder;
"""
  val getEnglishWordsFromHiragana = """
SELECT ew_word
FROM englishWord
INNER JOIN japaneseEnglishWordLink
ON englishWord.ew_wordid = japaneseEnglishWordLink.jewl_englishWordID
WHERE japaneseEnglishWordLink.jewl_japaneseWordID in (
      select jwkn_japaneseWordID
      from japaneseWordKanaLink
      inner join kanaSystem
      on jwkn_kanaID = kns_kanaID
      and kns_hiragana = ? --in ('や', 'ま')
)
order by japaneseEnglishWordLink.jewl_englishWordOrder;
"""
}
