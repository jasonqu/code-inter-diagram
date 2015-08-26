package svg

case class Point(x: Int, y: Int)

case class Size(width: Int, height: Int)


trait SvgGraph {
  def render: String
}

case class RectAngleWithText(origin: Point, size: Size, fillColor: String, content: String) extends SvgGraph {
  override def render: String = SvgConvertor.genRectText(this)
}

case class ClassDiagram(elemId: String, origin: Point, headerSize: Size, title: String, fillColor: String, contents: List[(String, String)])
  extends SvgGraph {
  lazy val cellHeight = headerSize.height
  lazy val size = contents.size
  lazy val header = RectAngleWithText(Point(0,0), headerSize, fillColor, title)
  lazy val rectangles: List[RectAngleWithText] =
    contents.zipWithIndex.foldRight(List[RectAngleWithText]()) { case (((key, value), index), list) =>
      RectAngleWithText(Point(origin.x, origin.y + cellHeight * (index + 1)),
        headerSize.copy(width = headerSize.width / 2), fillColor, key) ::
        RectAngleWithText(Point(origin.x + headerSize.width / 2, origin.y + cellHeight * (index + 1)),
          headerSize.copy(width = headerSize.width / 2), fillColor, value) ::
        list
    }

  override def render: String = SvgConvertor.genClassDiagram(this)
}