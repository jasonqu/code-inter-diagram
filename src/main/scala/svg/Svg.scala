package svg

case class Point(x: Int, y: Int)

case class Size(width: Int, height: Int)


trait SvgGraph {
  def render: String
}

case class RectAngleWithText(origin: Point, size: Size, fillColor: String, content: String, opacity: Double, `class`: String) extends SvgGraph {
  override def render: String = SvgConverter.genRectText(this)
}

case class ClassDiagram(elemId: String, origin: Point, headerSize: Size, title: String, fillColor: String, contents: List[(String, String)])
  extends SvgGraph {
  lazy val cellHeight = headerSize.height
  lazy val size = contents.size
  lazy val header = RectAngleWithText(Point(0, 0), headerSize, fillColor, title, 1, "header")
  lazy val rectangles: List[RectAngleWithText] =
    contents.zipWithIndex.foldRight(List[RectAngleWithText]()) { case (((key, value), index), list) =>
      RectAngleWithText(Point(0, cellHeight * (index + 1)),
        headerSize.copy(width = headerSize.width / 2), fillColor, key, 0.2, "content") ::
        RectAngleWithText(Point(headerSize.width / 2, cellHeight * (index + 1)),
          headerSize.copy(width = headerSize.width / 2), fillColor, value, 0.2, "content") ::
        list
    }

  override def render: String = SvgConverter.genClassDiagram(this)
}


case class Path(origin: Point, end: Point, deviation: Int = 0, horizontal: Boolean = true) extends SvgGraph {
  // M390,145 H450 V115 H492
  lazy val data =
    if(horizontal) {
      s"""M${origin.x},${origin.y} H${(end.x + origin.x)/2 + deviation} V${end.y} H${end.x - 8}"""
    } else {
      s"""M${origin.x},${origin.y} V${end.x} H${(end.y + origin.y)/2 + deviation} V${end.y - 8}"""
    }
  override def render: String = SvgConverter.genPath(this)
}

