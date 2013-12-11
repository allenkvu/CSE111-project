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



class DBConn {
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
  //case class Region (regionkey: Int, name: String, comment: String)
  case class Kana (wordID: Int, katakana: String, hiragana: String, romaji: String)
  case class Kangi (wordID: Int, kangi: String)
  case class EnglishWord (wordID: Int, englishWord: String)

}

object DBTools {

  def parseEnglishSetup(conn: Connection, text: String): List[DBTypes.EnglishWord] = {
    val wordsStrings = text.split(" ")
    for(word <- wordsStrings){
      if(DBQueries.englishWordExists(conn, word) == false){
        DBStatements.insertEnglishWord(conn, word)
      } 
    } 
    val arr = for(word <- wordsStrings) yield DBQueries.getEnglishWord(conn, word)
    arr.toList


  }
}

object DBQueries {




/*  
//  def newRegion(conn: Connection, r_regionkey: Int, r_name: String) = {
  def newRegion(conn: Connection) = {
    val prepStat: PreparedStatement = conn.prepareStatement("""insert into region values (4, 'foo', 'nocomment')""")
    //prepStat.setInt(1, r_regionkey)
    //prepStat.setString(2, r_name)
    try {
      prepStat.executeUpdate()
    } catch {
      case sqle: SQLException =>
        println("insert region failed")
        println(sqle.getMessage())
    }

  }
  def getRegion(conn: Connection): String = {
    val prepStat: PreparedStatement = conn.prepareStatement("""
select * from region
where r_regionkey = ?
limit 1
""")
    //prepStat.setString(1, "AFRICA")
    prepStat.setInt(1, 2)
    
    val result = prepStat.executeQuery()
    
    result.getString("r_name")
    
  }
 */
  def englishWordExists(conn: Connection, word: String): Boolean = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(QueryText.getEnglish)
      prepStat.setString(1, word)
      val resultSet: ResultSet = prepStat.executeQuery()
      val result = resultSet.getInt(1)
        //println(word)
      if(result==1) true else false

    } catch {
      case sqlnoelem: 
      case sqle: SQLException =>
        println("find English word failed")
        println(sqle.getMessage())
        false
    }
    
  }

  def 

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

}

object DBStatements {
  def insertEnglishWord(conn: Connection, word: String) = {
    try {
      val prepStat: PreparedStatement = conn.prepareStatement(StatementText.insertEnglishWord)
      prepStat.setString(1, word)
      prepStat.executeUpdate()
      
    } catch {
      case sqle: SQLException =>
        println("find English word failed")
        println(sqle.getMessage())
        false
    }
  }
    
}
