package svg.diagrams

import svg._

object Closure12 extends App {
  val headersize = Size(150, 30)
  val activate1 = ClassDiagram("activate", Point(600, 100), headersize, "Activation object", "rgba(51, 204, 51, 0.5)",
    ("this", "window") :: Nil)
  val activate2 = ClassDiagram("activate", Point(600, 200), headersize, "Activation object", "rgba(51, 204, 51, 0.5)",
    ("this", "window") :: Nil)
  val activate5 = ClassDiagram("activate", Point(600, 300), headersize, "Activation object", "rgba(51, 204, 51, 0.5)",
    ("this", "window") ::("arguments", "[5]") ::("size", "5") ::("i", "5") :: Nil)
  val global = ClassDiagram("global", Point(600, 480), headersize, "Global object", "rgba(255, 0, 102, 0.5)",
    ("this", "window") ::("window", "(object)") ::("createFuncs", "(function)") ::("funcs", "(array)") ::("i", "0") :: Nil)

  val closure1 = ClassDiagram("closure1", Point(100, 100), headersize, "closure1", "rgba(0, 102, 255, 0.5)", ("[[scope]]", "") :: Nil)
  val scope5 = ClassDiagram("scope5", Point(350, 100), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: ("1", "") :: ("2", "") :: Nil)

  val closure5 = ClassDiagram("closure5", Point(100, 300), headersize, "closure5", "rgba(0, 102, 255, 0.5)", ("[[scope]]", "") :: Nil)
  val scope10 = ClassDiagram("scope10", Point(350, 300), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: ("1", "") :: ("2", "") :: Nil)

  val path1 = Path(Point(212, 145), Point(350, 115))
  val path2 = Path(Point(462, 145), Point(600, 115))
  val path3 = Path(Point(462, 175), Point(600, 307))
  val path4 = Path(Point(462, 205), Point(600, 503), -10)

  val path5 = Path(Point(212, 345), Point(350, 315))
  val path6 = Path(Point(462, 345), Point(600, 215), 10)
  val path7 = Path(Point(462, 375), Point(600, 323), 20)
  val path8 = Path(Point(462, 405), Point(600, 487), 30)

  //  val path4 = Path(Point(212, 345), Point(350, 315))
//  val path5 = Path(Point(462, 365), Point(600, 120), 10)
//  val path6 = Path(Point(462, 395), Point(600, 265), 20)
//
//  val path7 = Path(Point(212, 485), Point(350, 455))
//  val path8 = Path(Point(462, 485), Point(600, 110), 40)
//  val path9 = Path(Point(462, 515), Point(600, 273), 30)

  (closure1 :: scope5 :: closure5 :: scope10 :: activate1 :: activate2 :: activate5 :: global :: path1 :: path2 :: path3 :: path4 :: path5 :: path6 :: path7 :: path8 :: List[SvgGraph]()).map(_.render) foreach println
}
