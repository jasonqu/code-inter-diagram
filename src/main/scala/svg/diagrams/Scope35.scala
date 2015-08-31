package svg.diagrams

import svg._

object Scope35 extends App {
  val headersize = Size(150, 30)
  val activateClosure = ClassDiagram("activate", Point(600, 50), headersize, "Activation object", "rgba(51, 204, 51, 0.5)",
    ("this", "window") ::("arguments", "[2]") ::("y", "2") :: Nil)


  val ec = ClassDiagram("add", Point(100, 200), headersize, "execution context", "rgba(0, 102, 255, 0.5)", ("scope chain", "") :: Nil)
  val scopeec = ClassDiagram("scope", Point(350, 200), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: ("1", "") :: ("2", "") :: Nil)
  val activate5 = ClassDiagram("activate", Point(600, 200), headersize, "Activation object", "rgba(51, 204, 51, 0.5)",
    ("this", "window") ::("arguments", "[5]") ::("x", "5") :: Nil)
  val global = ClassDiagram("global", Point(600, 350), headersize, "Global object", "rgba(255, 0, 102, 0.5)",
    ("this", "window") ::("window", "(object)") ::("makeAdder", "(function)") ::("add5", "(function)") ::("add10", "(function)") :: Nil)

  val add5 = ClassDiagram("add5", Point(100, 370), headersize, "add5", "rgba(0, 102, 255, 0.5)", ("[[scope]]", "") :: Nil)
  val scope5 = ClassDiagram("scope5", Point(350, 370), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: ("1", "") :: Nil)

  val add10 = ClassDiagram("add10", Point(100, 540), headersize, "add10", "rgba(0, 102, 255, 0.5)", ("[[scope]]", "") :: Nil)
  val scope10 = ClassDiagram("scope10", Point(350, 540), headersize, "Scope Chain", "rgba(255, 153, 0, 0.5)", ("0", "") :: ("1", "") :: Nil)
  val activate10 = ClassDiagram("activate10", Point(600, 560), headersize, "Activation object", "rgba(51, 204, 51, 0.5)",
    ("this", "window") ::("arguments", "[10]") ::("x", "10") :: Nil)

  val path1 = Path(Point(212, 245), Point(350, 215))
  val pathclosure = Path(Point(462, 245), Point(600, 65), -10)
  val path2 = Path(Point(462, 275), Point(600, 210))
  val path3 = Path(Point(462, 305), Point(600, 357))

  val path4 = Path(Point(212, 415), Point(350, 385))
  val path5 = Path(Point(462, 415), Point(600, 220), 10)
  val path6 = Path(Point(462, 445), Point(600, 365), 20)

  val path7 = Path(Point(212, 585), Point(350, 555))
  val path8 = Path(Point(462, 585), Point(600, 575), 40)
  val path9 = Path(Point(462, 615), Point(600, 373), 30)

  (add5 :: scope5 :: add10 :: scope10 :: ec :: scopeec :: activateClosure :: activate5 :: activate10 :: global :: path1 :: path2 :: path3 :: path4 :: path5 :: path6 :: path7 :: path8 :: path9 :: pathclosure ::List[SvgGraph]()).map(_.render) foreach println
}
