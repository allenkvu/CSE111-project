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



class DBConn {
  val foo = "bar"

  val jdbc = Class.forName("org.sqlite.JDBC")
  try {
    val conn = DriverManager.getConnection("jdbc:sqlite:lab3db")
    val stat = conn.createStatement();
  } catch {
    case sqle: SQLException => 
      println("connection not made to sqlite DB")
      println(sqle.getMessage())
      sys.exit(0)
  }

}

object DBTypes {
  case class Region (regionkey: Int, name: String, comment: String)

}

object DBTools {

  def getEnglish(conn: DBConn): String = {
    //val q = sql"select * from region limit 1".as[DBTypes.Region]
    //q.name
    //Q.
    "foo"

  }
}

