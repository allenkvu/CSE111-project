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
    
}
