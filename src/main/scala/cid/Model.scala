package cid

case class Blocks(min:Int, max:Int, children :List[Blocks] = Nil)

// 10 个字符要 加大 width
case class ObjectDesc(id: String, params: Map[String, String])

case class Rectangular(id: String = "", key:String, value:String) {
  lazy val maxStrLength = Math.max(key.length, value.length)
  lazy val width = if(maxStrLength >= 10) 60 + (maxStrLength - 9) * 7 else 60
}

case class ObjectRect(id: String, startX:Int, startY:Int, params: List[Rectangular]) {
  lazy val width = params.map(_.width).max
}


