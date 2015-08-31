package svg.diagrams

import svg._

object Scope21 extends App {
  // scope chain
  val headersize = Size(135, 30)
  val add = ClassDiagram("add", Point(100, 100), headersize, "Add", "rgba(0, 102, 255, 0.5)", ("[[scope]]", "") :: Nil)
  val scope = ClassDiagram("scope", Point(350, 100), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: Nil)
  val act = ClassDiagram("global", Point(600, 100), headersize, "Global object", "rgba(255, 0, 102, 0.5)",
    ("this", "window") ::("window", "(object)") :: Nil)


  val path1 = Path(Point(205, 145), Point(350, 115))
  val path2 = Path(Point(455, 145), Point(600, 115))

  (add :: scope :: act :: path1 :: path2 :: List[SvgGraph]()).map(_.render) foreach println
}
