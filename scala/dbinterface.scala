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
    conn = DriverManager.getConnection("jdbc:sqlite:translator.db")
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
  case class Region (regionkey: Int, name: String, comment: String)

}

object DBTools {
  
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
}

