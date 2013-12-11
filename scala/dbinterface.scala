package translator

//import scala.slick.driver.SQLiteDriver.simple._
/*import scala.slick.session.Database
 import Database.threadLocalSession
 import scala.slick.jdbc.{GetResult, StaticQuery => Q}
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

import java.sql.PreparedStatement;



class DBInterface {
  val foo = "bar"

  val jdbc = Class.forName("org.sqlite.JDBC")
  var conn: Connection = null
  var stat: Statement = null

  try {
    //conn = DriverManager.getConnection("jdbc:sqlite:lab3db")
    //conn = DriverManager.getConnection("jdbc:sqlite:translator.db")
    conn = DriverManager.getConnection("jdbc:sqlite:foobar.db")

    stat = conn.createStatement();
  } catch {
    case sqle: SQLException =>
      println("connection not made to sqlite DB")
      println(sqle.getMessage())
      //conn.close()
      sys.exit(0)
  }




  def getConn: Connection = if(conn != null) conn else {
    throw new Exception
  }
  
  def getStat: Statement = if(stat != null) stat else {
    throw new Exception
  }

}

object DBTypes {

  case class JapaneseWord (wordID: Int)
  case class Kana (wordID: Int, katakana: String, hiragana: String, romaji: String)
  case class Kanji (wordID: Int, kangi: String)
  case class EnglishWord (wordID: Int, englishWord: String)

}

object DBTools {

  def parseEnglish(conn: Connection, text: String): List[DBTypes.EnglishWord] = {
    val wordsStrings = text.split(" ")
    for(word <- wordsStrings){
      if(DBQueries.englishWordExists(conn, word) == false){
        DBStatements.insertEnglishWord(conn, word)
      } 
    } 
    val arr = for(word <- wordsStrings) yield DBQueries.getEnglishWord(conn, word)
    arr.toList


  }
  def parseKanji(conn: Connection, text: String): List[DBTypes.Kanji] = {
    val wordsStrings = text.split("").toList.filter(_!="").filter(_!=" ")
    for(word <- wordsStrings){
      if(DBQueries.kanjiExists(conn, word) == false){
        DBStatements.insertKanji(conn, word)
      } 
    } 
    val arr = for(word <- wordsStrings) yield DBQueries.getKanji(conn, word)
    arr.toList


  }

}


