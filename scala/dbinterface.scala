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

  def idTupleConstructor(ll: List[Int]): String = {
    for(i<-ll){println(i)}
    val tup = ll.foldLeft("(")(_+_+",")
    val tup2 = tup.substring(0,tup.length-1)

    println(tup2)
    tup2
  }

  def parseEnglish(conn: Connection, text: String): List[DBTypes.EnglishWord] = {
    val wordsStrings = text.split(" ")
    println("parsed English to")
    wordsStrings.map(println(_))
    for(word <- wordsStrings){
      if(DBQueries.englishWordExists(conn, word) == false){
        DBStatements.insertEnglishWord(conn, word)
      }
    }
    val arr = for(word <- wordsStrings) yield DBQueries.getEnglishWord(conn, word)
    arr.toList


  }
  def parseKanji(conn: Connection, text: String): List[DBTypes.Kanji] = {
    //val wordsStrings = text.split("").toList.filter(_!="").filter(_!=" ")
    val wordsStrings = text.split(" ").toList.filter(_!="").filter(_!=" ")
    //    println("parsed Kanji to")
    //  wordsStrings.map(println(_))
    /*for(word <- wordsStrings){
     if(DBQueries.kanjiExists(conn, word) == false){
     println("Kanji does not exist in DB")
     DBStatements.insertKanji(conn, word)
     } 
     } */
    wordsStrings.map((s) => {
      if(DBQueries.kanjiExists(conn, s) == false){
        println("Kanji does not exist in DB")
        DBStatements.insertKanji(conn, s)
      }
    })
    printf("return list")
    val arr = for(word <- wordsStrings) yield DBQueries.getKanji(conn, word)
    arr.toList


  }

  def parseKana(conn: Connection, 
    katakana: String, hiragana: String, romaji: String): List[DBTypes.Kana] = {
    val katakanaStrings = katakana.split(" ").toList.filter(_!="").filter(_!=" ")
    val hiraganaStrings = katakana.split(" ").toList.filter(_!="").filter(_!=" ")
    val romajiStrings = katakana.split(" ").toList.filter(_!="").filter(_!=" ")
    if(hiragana == "" && romaji == ""){
      // use katakana
      val validKatakana = katakanaStrings.filter((s) => {
        DBQueries.katakanaExists(conn, s) == true
      })
      val arr = for(word <- validKatakana) yield DBQueries.getKana(conn, "", word, "")
      arr.toList
    }else if(hiragana == "" && katakana == ""){
      val validRomaji = romajiStrings.filter((s) => {
        DBQueries.romajiExists(conn, s) == true
      })
      val arr = for(word <- validRomaji) yield DBQueries.getKana(conn, word, "", "")
      arr.toList

    }else if(katakana == "" && romaji == ""){
      val validHiragana = hiraganaStrings.filter((s) => {
        DBQueries.hiraganaExists(conn, s) == true
      })
      val arr = for(word <- validHiragana) yield DBQueries.getKana(conn, "", "", word)
      arr.toList

    }else
      List[DBTypes.Kana]()


  }
  
  //////////////////////
  // links
  def getJapaneseWordFromKana(conn: Connection, kanaList: List[DBTypes.Kana]): DBTypes.JapaneseWord = {
    val jWord = DBQueries.japaneseWordKanaLinkExists(conn, kanaList)
    if(jWord.wordID == -1) { // does not exist
      val jWord2 = DBStatements.insertJapaneseWordKanaLink(conn, kanaList)
      jWord2
    } else
      jWord
  }

}


