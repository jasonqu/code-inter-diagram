package svg.diagrams

import svg.{SvgGraph, Point, ClassDiagram, Size}

object Scope1 extends App {
  // scope chain
  val color = "rgba(0,0,255,0.5)"
  val headersize = Size(170, 30)
  val third = ClassDiagram("third", Point(40, 200), headersize, "third", color,
    ("text", "argument")
      :: Nil)
  val second = ClassDiagram("second", Point(40, 50), headersize, "second", color,
    ("insideFirst", "inside second")
      :: Nil)
  val first = ClassDiagram("first", Point(280, 125), headersize, "first", "rgba(204, 102, 255, 0.5)",
    ("insideFirst", "inside first")
      :: ("second", "(function)")
      :: ("third", "(function)")
      :: Nil)
  val anotherFunc = ClassDiagram("anotherFunc", Point(280, 325), headersize, "anotherFunc", "rgba(204, 102, 255, 0.5)", Nil)
  val global = ClassDiagram("global", Point(520, 225), headersize, "Global object", "rgba(255, 0, 102, 0.5)",
    ("window", "(object)")
      :: ("text", "exposed!")
      ::("first", "(function)")
      :: ("anotherFunc", "(function)")
      :: ("insideThird", "inside third")
      :: Nil)

  //    val path1 = Path(Point(second.origin.x + headersize.width, second.origin.y + 15),
  //      first.origin.copy(y = first.origin.y + 10))
  //    val path2 = Path(Point(390, 145), Point(500, 115))

  (third :: second :: first :: anotherFunc :: global :: genPath(third, first) :: genPath(second, first) :: genPath(first, global) :: genPath(anotherFunc, global) :: List[SvgGraph]()).map(_.render) foreach println

}
