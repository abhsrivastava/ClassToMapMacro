import com.abhi.ToMap
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by ASrivastava on 7/4/17.
  */
class ToMapTest extends FunSuite with Matchers {
   test("test the top map functionality") {
      @ToMap
      case class Person(name: String, age: Int)
      val x = Person("foo", 20)
      val map = x.toMap()
      map.get("name") should equal (Some("foo"))
      map.get("age") should equal (Some(20))
      map.get("foo") should not be ('defined)
   }
}
