package svg.diagrams

import svg._

object Scope23 extends App {
  // scope chain
  val headersize = Size(150, 30)
  val ec = ClassDiagram("ec", Point(100, 100), headersize, "execution context", "rgba(0, 102, 255, 0.5)", ("scope chain", "") :: Nil)
  val scopeec = ClassDiagram("scope", Point(350, 100), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: Nil)
  val global = ClassDiagram("global", Point(600, 150), headersize, "Global object", "rgba(255, 0, 102, 0.5)",
    ("this", "window") ::("window", "(object)") ::("add", "(function)") ::("total", "15") :: Nil)

  val path1 = Path(Point(212, 145), Point(350, 115))
  val path2 = Path(Point(462, 145), Point(600, 162))

  val add = ClassDiagram("add", Point(100, 300), headersize, "Add", "rgba(0, 102, 255, 0.5)", ("[[scope]]", "") :: Nil)
  val scope = ClassDiagram("scope", Point(350, 300), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: Nil)

  val path4 = Path(Point(212, 345), Point(350, 315))
  val path5 = Path(Point(462, 345), Point(600, 173))

  (add :: scope :: global :: ec :: scopeec :: path1 :: path2 :: path4 :: path5 :: List[SvgGraph]()).map(_.render) foreach println
}
