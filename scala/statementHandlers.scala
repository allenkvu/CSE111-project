package translator


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

import java.sql.PreparedStatement;


object DBStatements {
  def insertEnglishWord(conn: Connection, word: String) = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(StatementText.insertEnglishWord)
      prepStat.setString(1, word)
      prepStat.executeUpdate()
      
    } catch {
      case sqle: SQLException =>
        println("insert English word failed")
        println(sqle.getMessage())
        false
    }
  }
  def insertKanji(conn: Connection, word: String) = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(StatementText.insertKanji)
      prepStat.setString(1, word)
      prepStat.executeUpdate()
      
    } catch {
      case sqle: SQLException =>
        println("insert Kanji failed")
        println(sqle.getMessage())
        false
    }
  }
  def japaneseWordKanaLinkQuery(conn: Connection, jID: Int, i: Int, kana: DBTypes.Kana) = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(
        """insert into japaneseWordKanaLink values (?, ?, ?);"""
      )
      prepStat.setInt(1, jID)
      prepStat.setInt(2, kana.wordID)
      prepStat.setInt(3, i)
      prepStat.executeUpdate()
    } catch {
      case sqle: SQLException =>
        println("insert jwkl failed")
        println(sqle.getMessage())
    }
  }

  // Assumes valid Kana List
  def insertJapaneseWordKanaLink(conn: Connection, kanaList: List[DBTypes.Kana]): DBTypes.JapaneseWord = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(
        """select max(jw_WordID) from japaneseWord;"""
      )
      val resultSet: ResultSet = prepStat.executeQuery()
      if(resultSet.next()){
        val newJWordID = resultSet.getInt(1)
        for(i <- 0 to kanaList.length-1){
          japaneseWordKanaLinkQuery(conn, newJWordID, i, kanaList(i))
        }
        new DBTypes.JapaneseWord(newJWordID)
      }
      new DBTypes.JapaneseWord(-1)

    } catch {
      case sqle: SQLException =>
        println("insert jwkl failed")
        println(sqle.getMessage())
        new DBTypes.JapaneseWord(-1)
    }

  }
}
