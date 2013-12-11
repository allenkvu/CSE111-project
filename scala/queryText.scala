package translator

object QueryText {

  val getEnglishWords = """select * from englishWord;"""
  val getEnglishWord = """select * from englishWord where ew_word = ?;"""
  val englishWordCount = """select count(*) from englishWord where ew_word = ?;"""
  val getKana = """select * from kanaSystem;"""
  val getHiragana = """select kns_hiragana from kanaSystem;"""
  val getKatakana = """select kns_katakana from kanaSystem;"""
  val getRomaji = """select kns_romaji from kanaSystem;"""
  val getKangi = """select * from kangiSystem;"""

  val getKanaFromEnglishWord = """
SELECT kns_hiragana, kns_katakana, kns_romaji
FROM kanaSystem
INNER JOIN japaneseWordKanaLink
INNER JOIN japaneseEnglishWordLink
ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID
AND japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID
WHERE japaneseEnglishWordLink.jewl_englishWordID = (
      select ew_wordID from englishWord where ew_word = '?'
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
      and kns_hiragana = '?' --in ('や', 'ま')
)
order by japaneseEnglishWordLink.jewl_englishWordOrder;
"""
}
