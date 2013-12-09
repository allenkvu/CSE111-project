package translator

import scala.slick.driver.SQLiteDriver.simple._
import Database.threadLocalSession

class dbConn {
  val foo = "bar"

  Database.forURL("jdbc:sqlite:lab3db")

  



}

object dbTools {
  def getEnglish(conn: dbConn): String = {
    "baz"

  }
}
