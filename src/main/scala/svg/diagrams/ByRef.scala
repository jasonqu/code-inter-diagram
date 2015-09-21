package svg.diagrams

import svg._

object ByRef extends App {
  val headersize = Size(150, 30)
  val var1 = ClassDiagram("num1", Point(100, 100), headersize, "复制前", "rgba(0, 102, 255, 0.5)",
    ("", "") ::("", "") ::("a", "") :: Nil)
  val var11 = ClassDiagram("num11", Point(400, 190), headersize, "Object", "rgba(51, 204, 51, 0.5)",
    ("name", "a") :: Nil)

  val var2 = ClassDiagram("num2", Point(100, 300), headersize, "复制后", "rgba(0, 102, 255, 0.5)",
    ("", "") :: ("b", "") :: ("a", "") :: Nil)
  val var22 = ClassDiagram("num22", Point(400, 375), headersize, "Object", "rgba(51, 204, 51, 0.5)",
    ("name", "a") :: Nil)

  val var3 = ClassDiagram("num3", Point(100, 500), headersize, "修改b的name", "rgba(0, 102, 255, 0.5)",
    ("", "") :: ("b", "") :: ("a", "") :: Nil)
  val var33 = ClassDiagram("num33", Point(400, 575), headersize, "Object", "rgba(51, 204, 51, 0.5)",
    ("name", "b") :: Nil)

  val path1 = Path(Point(212, 205), Point(400, 205))

  val path2 = Path(Point(212, 375), Point(400, 390))
  val path22 = Path(Point(212, 405), Point(400, 390))

  val path3 = Path(Point(212, 575), Point(400, 590))
  val path33 = Path(Point(212, 605), Point(400, 590))

  (var1::var11::var2::var22 ::var3::var33::path1::path2::path22::path3::path33::Nil).map(_.render) foreach println
}
