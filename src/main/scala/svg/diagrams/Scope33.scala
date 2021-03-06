package svg.diagrams

import svg._

object Scope33 extends App {
  val headersize = Size(150, 30)
  val ec = ClassDiagram("add", Point(100, 100), headersize, "execution context", "rgba(0, 102, 255, 0.5)", ("scope chain", "") :: Nil)
  val scopeec = ClassDiagram("scope", Point(350, 100), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: ("1", "") :: Nil)
  val activate = ClassDiagram("activate", Point(600, 100), headersize, "Activation object", "rgba(51, 204, 51, 0.5)",
    ("this", "window") ::("arguments", "[5]") ::("x", "5") :: Nil)
  val global = ClassDiagram("global", Point(600, 300), headersize, "Global object", "rgba(255, 0, 102, 0.5)",
    ("this", "window") ::("window", "(object)") ::("makeAdder", "(function)") ::("add5", "(function)") :: Nil)

  val add = ClassDiagram("add", Point(100, 300), headersize, "add5", "rgba(0, 102, 255, 0.5)", ("[[scope]]", "") :: Nil)
  val scope = ClassDiagram("scope", Point(350, 300), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: ("1", "") :: Nil)

  val path1 = Path(Point(212, 145), Point(350, 115))
  val path2 = Path(Point(462, 145), Point(600, 110))
  val path3 = Path(Point(462, 175), Point(600, 307))

  val path4 = Path(Point(212, 345), Point(350, 315))
  val path5 = Path(Point(462, 345), Point(600, 120), 10)
  val path6 = Path(Point(462, 375), Point(600, 323), 20)

  (add :: scope :: ec :: scopeec :: activate :: global :: path1 :: path2 :: path3 :: path4 :: path5 :: path6 :: List[SvgGraph]()).map(_.render) foreach println
}
