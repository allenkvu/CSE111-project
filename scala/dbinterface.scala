package translator

//import scala.slick.driver.SQLiteDriver.simple._
import scala.slick.session.Database
import Database.threadLocalSession
import scala.slick.jdbc.{GetResult, StaticQuery => Q}

class DBConn {
  val foo = "bar"

  Database.forURL("jdbc:sqlite:lab3db") with Session {



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
