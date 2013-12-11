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



  def englishWordExists(conn: Connection, word: String): Boolean = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(QueryText.getEnglish)
      prepStat.setString(1, word)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)
      //println(word)
      if(result==1) true else false

    } catch {
      //      case sqlnoelem:
      case sqle: SQLException =>
        println("find English word failed")
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
        println("get english words failed")
        println(sqle.getMessage())
        DBTypes.EnglishWord(0, "NONE")
    }
    
  }
  /*
   def getEnglishWords(conn: Connection): List[DBTypes.EnglishWord] = {
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
