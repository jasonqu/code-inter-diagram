package svg

trait Svg

case class Group(id:Option[String], className:Option[String], children : List[Svg])


abstract class Elem(x:Int, y:Int, width:Int, height:Int, fill:Option[String],
                    stroke_width:Option[Int],stroke:Option[String])

class Rect() extends Elem {



}

case class Text(x:Int, y:Int, width:Int, height:Int, fill:Option[String],
  className:Option[String],text_anchor:String = "middle", value:String)

case class RectText()



