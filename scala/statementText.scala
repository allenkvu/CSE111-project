package translator

object StatementText {
  val insertEnglishWord = """insert into englishWord (ew_word) values (?)"""
  val insertJapaneseWord = """insert into japaneseWord values (NULL);"""
  val insertKanji = """insert into kanjiSystem values (NULL, '?');"""
  // not necessary to insert Kana characters


  val insertJapaneseWordKanaLink = """insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (?, ?, ?);
"""

}
