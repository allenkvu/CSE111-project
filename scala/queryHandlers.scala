package translator


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

import java.sql.PreparedStatement;


object DBQueries {
  /*
   englishWordExists
   getEnglishWord


   */

  // all word counts
  def englishWordCount(conn: Connection): Int = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(
        QueryText.englishCount)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)
      result

    } catch {
      case sqle: SQLException =>
        println("English word count failed")
        println(sqle.getMessage())
        -1
    }
    
  }
  def japaneseWordCount(conn: Connection): Int = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(
        QueryText.japaneseCount)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)
      result

    } catch {
      case sqle: SQLException =>
        println("Japanese word count failed")
        println(sqle.getMessage())
        -1
    }
    
  }
  def kanaWordCount(conn: Connection): Int = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(
        QueryText.kanaCount)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)
      result

    } catch {
      case sqle: SQLException =>
        println("Japanese word count failed")
        println(sqle.getMessage())
        -1
    }
    
  }
  def kanjiWordCount(conn: Connection): Int = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(
        QueryText.kanjiCount)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)
      result

    } catch {
      case sqle: SQLException =>
        println("Kanji word count failed")
        println(sqle.getMessage())
        -1
    }
    
  }
  // all link counts
  def japaneseEnglishWordLinkCount(conn: Connection): Int = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(
        QueryText.japaneseEnglishLinkCount)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)
      result

    } catch {
      case sqle: SQLException =>
        println("Japanese English word link count failed")
        println(sqle.getMessage())
        -1
    }
    
  }

//////////////////////////////////////////

  def englishWordExists(conn: Connection, word: String): Boolean = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(QueryText.englishExists)
      prepStat.setString(1, word)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)
      //println(word)
      if(result==1) true else false

    } catch {
      //      case sqlnoelem:
      case sqle: SQLException =>
        println("English exists failed")
        println(sqle.getMessage())
        false
    }
    
  }

  /* Do not insert any new Kana characters */

  def katakanaExists(conn: Connection, katakana: String): Boolean = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(QueryText.katakanaExists)
      prepStat.setString(1, katakana)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)
      //println(word)
      if(result==1) true else false

    } catch {
      //      case sqlnoelem:
      case sqle: SQLException =>
        println("katkana exists failed")
        println(sqle.getMessage())
        false
    }
    
  }
  def hiraganaExists(conn: Connection, hiragana: String): Boolean = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(QueryText.hiraganaExists)
      prepStat.setString(1, hiragana)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)
      //println(word)
      if(result==1) true else false

    } catch {
      //      case sqlnoelem:
      case sqle: SQLException =>
        println("hiragana exists failed")
        println(sqle.getMessage())
        false
    }
    
  }
  def romajiExists(conn: Connection, romaji: String): Boolean = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(QueryText.romajiExists)
      prepStat.setString(1, romaji)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)
      //println(word)
      if(result==1) true else false

    } catch {
      //      case sqlnoelem:
      case sqle: SQLException =>
        println("romaji exists failed")
        println(sqle.getMessage())
        false
    }
    
  }

  def kanaExists(conn: Connection,
    hiragana: String, katakana: String, romaji: String): Boolean = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(QueryText.kanaExists)
      prepStat.setString(1, hiragana)
      prepStat.setString(2, katakana)
      prepStat.setString(3, romaji)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)
      //println(word)
      if(result==1) true else false

    } catch {
      //      case sqlnoelem:
      case sqle: SQLException =>
        println("English exists failed")
        println(sqle.getMessage())
        false
    }
    
  }

  def kanjiExists(conn: Connection, word: String): Boolean = {

    try {
      val prepStat: PreparedStatement = conn.prepareStatement(QueryText.kanjiExists)
      prepStat.setString(1, word)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)

      if(result==1) true else false

    } catch {
      //      case sqlnoelem:
      case sqle: SQLException =>
        println("Kanji exists failed")
        println(sqle.getMessage())
        false
    }
    
  }


  //  def

  def getEnglishWord(conn: Connection, wordIn: String): DBTypes.EnglishWord = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(QueryText.getEnglish)
      prepStat.setString(1, wordIn)
      val resultSet: ResultSet = prepStat.executeQuery()

      var word: String = ""
      if(resultSet.next()){
        //print("got English word  ")
        val id = resultSet.getInt("ew_wordID")
        val word = resultSet.getString("ew_word")

        new DBTypes.EnglishWord(id, word)

      } else { // not found
        new DBTypes.EnglishWord(0, "NONE")
      }
    } catch {
      case sqle: SQLException =>
        println("get english word failed")
        println(sqle.getMessage())
        DBTypes.EnglishWord(0, "NONE")
    }
    
  }

  def getKanji(conn: Connection, wordIn: String): DBTypes.Kanji = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(QueryText.getKanji)
      prepStat.setString(1, wordIn)
      val resultSet: ResultSet = prepStat.executeQuery()

//      var word: String = ""
      if(resultSet.next()){
  
        val id = resultSet.getInt("ks_kanjiID")
        val word = resultSet.getString("ks_char")

        new DBTypes.Kanji(id, word)

      } else { // not found
        new DBTypes.Kanji(0, "NONE")
      }
    } catch {
      case sqle: SQLException =>
        println("get kanji failed")
        println(sqle.getMessage())
        DBTypes.Kanji(0, "NONE")
    }
    
  }
  def getKana(conn: Connection,
    hiragana: String, katakana: String, romaji: String): DBTypes.Kana = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(QueryText.getKana)
      prepStat.setString(1, hiragana)
      prepStat.setString(2, katakana)
      prepStat.setString(3, romaji)
      val resultSet: ResultSet = prepStat.executeQuery()
      if(resultSet.next()){
        new DBTypes.Kana(resultSet.getInt("kns_kanaID"),
          resultSet.getString("kns_katakana"),
          resultSet.getString("kns_hiragana"),
          resultSet.getString("kns_romaji")
        )
      } else {
        new DBTypes.Kana(0, "NONE", "NONE", "NONE")
      }
    } catch {
      case sqle: SQLException =>
        println("get kana failed")
        println(sqle.getMessage())
        new DBTypes.Kana(0, "NONE", "NONE", "NONE")
    }

  }

  def japaneseWordKanaLinkExists(conn: Connection, kanaList: List[DBTypes.Kana]): DBTypes.JapaneseWord = {
    //val kanaIDs = kanaList.map(_.wordID)
    val kanaIDs = for(kana <- kanaList) yield kana.wordID
    val tup = DBTools.idTupleConstructor(kanaIDs)
    val q = """select jwkn_japaneseWordID, count(*) from japaneseWordKanaLink
where jwkn_kanaID in """+tup+""" group by jwkn_japaneseWordID having count(*)="""+kanaList.length+""";"""
    try {
      println(q)
      val prepStat: PreparedStatement = conn.prepareStatement(q)
      val resultSet: ResultSet = prepStat.executeQuery()
      if(resultSet.next()){
        val japaneseWordID = resultSet.getInt(1)
        new DBTypes.JapaneseWord(japaneseWordID)
      } else {
        new DBTypes.JapaneseWord(-1)
      }
    } catch {
      case sqle: SQLException =>
        println("get kana j word link failed")
        println(sqle.getMessage())
        new DBTypes.JapaneseWord(-1)
    }
  }
      



/*
  def getEnglishWords(conn: Connection, wordList = List[String]): List[DBTypes.EnglishWord] = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(QueryText.getEnglishWords)
      val resultSet: ResultSet = prepStat.executeQuery()
      var outputSet = List[DBTypes.EnglishWord]()
      var id: Int = 0
      var word: String = ""
      while(resultSet.next()){
        //print("got English word  ")
        id = resultSet.getInt("ew_wordID")
        word = resultSet.getString("ew_word")

        outputSet = outputSet :+ new DBTypes.EnglishWord(id, word)
      }
      outputSet

    } catch {
      case sqle: SQLException =>
        println("get english words failed")
        println(sqle.getMessage())
        List[DBTypes.EnglishWord]()
    }
  }
 */

}
