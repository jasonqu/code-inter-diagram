package svg.diagrams

import svg._

object Scope36 extends App {
  val headersize = Size(150, 30)
  val ec = ClassDiagram("add", Point(100, 100), headersize, "execution context", "rgba(0, 102, 255, 0.5)", ("scope chain", "") :: Nil)
  val scopeec = ClassDiagram("scope", Point(350, 100), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: ("1", "") :: ("2", "") :: Nil)
  val activate5 = ClassDiagram("activate", Point(600, 100), headersize, "Activation object", "rgba(51, 204, 51, 0.5)",
    ("this", "window") ::("arguments", "[5]") ::("x", "5") :: Nil)
  val global = ClassDiagram("global", Point(600, 250), headersize, "Global object", "rgba(255, 0, 102, 0.5)",
    ("this", "window") ::("window", "(object)") ::("makeAdder", "(function)") ::("add5", "(function)") ::("add10", "(function)") :: Nil)

  val add5 = ClassDiagram("add5", Point(100, 270), headersize, "add5", "rgba(0, 102, 255, 0.5)", ("[[scope]]", "") :: Nil)
  val scope5 = ClassDiagram("scope5", Point(350, 270), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: ("1", "") :: Nil)

  val add10 = ClassDiagram("add10", Point(100, 440), headersize, "add10", "rgba(0, 102, 255, 0.5)", ("[[scope]]", "") :: Nil)
  val scope10 = ClassDiagram("scope10", Point(350, 440), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: ("1", "") :: Nil)
  val activate10 = ClassDiagram("activate10", Point(600, 460), headersize, "Activation object", "rgba(51, 204, 51, 0.5)",
    ("this", "window") ::("arguments", "[10]") ::("x", "10") :: Nil)

  val activateclosure = ClassDiagram("activateclosure", Point(600, 600), headersize, "Activation object", "rgba(51, 204, 51, 0.5)",
    ("this", "window") ::("arguments", "[2]") ::("y", "2") :: Nil)

  val path1 = Path(Point(212, 145), Point(350, 115))
  val pathclosure = Path(Point(462, 145), Point(600, 615), -10)
  val path2 = Path(Point(462, 175), Point(600, 110))
  val path3 = Path(Point(462, 205), Point(600, 257))

  val path4 = Path(Point(212, 315), Point(350, 285))
  val path5 = Path(Point(462, 315), Point(600, 120), 10)
  val path6 = Path(Point(462, 345), Point(600, 265), 20)

  val path7 = Path(Point(212, 485), Point(350, 455))
  val path8 = Path(Point(462, 485), Point(600, 475), 40)
  val path9 = Path(Point(462, 515), Point(600, 273), 30)

  (add5 :: scope5 :: add10 :: scope10 :: ec :: scopeec :: activate5 :: activateclosure :: activate10 :: global :: path1 :: path2 :: path3 :: path4 :: path5 :: path6 :: path7 :: path8 :: path9 :: pathclosure :: List[SvgGraph]()).map(_.render) foreach println
}
