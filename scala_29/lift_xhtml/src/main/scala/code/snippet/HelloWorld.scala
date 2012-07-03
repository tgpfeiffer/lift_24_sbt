package code
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import code.model._
import Helpers._

class HelloWorld {
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  // replace the contents of the element with id "time" with the date
  def howdy = "#time *" #> {
    val u = User.create.firstName("test").saveMe
    println(u)                 // code.model.User={id=3,firstName=test,lastName=,email=,locale=de_DE,timezone=Europe/Berlin,password=*******,textArea=,duration=NULL,uniqueId=BTE21KVDMXGAVSK4R3FKNTSMLDEBRUXO,validated=false,superUser=false}
    println(u.duration)        // NULL
    val b = Box !! u.duration
    println(b)                 // Full(NULL)
    // the following line will throw a NullPointerException
    b.map(_.getHours)
    "fail"
  }

  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */
}

