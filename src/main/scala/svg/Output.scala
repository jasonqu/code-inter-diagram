package svg

object Output extends App {
  var x = false
  if(x) {
    val color = "rgba(0,0,255,0.5)"
    val headersize = Size(120, 30)
    val add = ClassDiagram("num0", Point(100, 100), headersize, "Add", color, ("[[scope]]", "") :: Nil)
    val scope = ClassDiagram("num1", Point(300, 100), headersize, "Scope Chain", color, ("0", "") :: Nil)
    val act = ClassDiagram("num2", Point(500, 100), headersize, "Global object", color,
      ("this", "window") ::("window", "(object)") ::("add", "(function)") :: Nil)


    val path1 = Path(Point(190, 145), Point(300, 115))
    val path2 = Path(Point(390, 145), Point(500, 115))

    (add :: scope :: act :: path1 :: path2 :: List[SvgGraph]()).map(_.render) foreach println
  } else {
    // scope chain
    val color = "rgba(0,0,255,0.5)"
    val headersize = Size(170, 30)
    val third = ClassDiagram("third", Point(100, 200), headersize, "third", color,
      ("text", "argument")
        :: ("insideThird", "inside third")
        :: Nil)
    val second = ClassDiagram("second", Point(100, 50), headersize, "second", color,
      ("insideFirst", "inside second")
        :: Nil)
    val first = ClassDiagram("first", Point(340, 125), headersize, "first", color,
      ("insideFirst", "inside first")
        :: ("second", "(function)")
        :: ("third", "(function)")
        :: Nil)
    val anotherFunc = ClassDiagram("anotherFunc", Point(340, 325), headersize, "anotherFunc", color, Nil)
    val global = ClassDiagram("global", Point(580, 225), headersize, "Global object", color,
        ("window", "(object)")
        :: ("text", "exposed!")
        ::("first", "(function)")
        :: ("anotherFunc", "(function)")
        :: Nil)

    val path1 = Path(Point(second.origin.x + headersize.width, second.origin.y + 15),
      first.origin.copy(y = first.origin.y + 10))
    val path2 = Path(Point(390, 145), Point(500, 115))

    (third :: second :: first :: anotherFunc :: global :: genPath(third, first) :: genPath(second, first) :: genPath(first, global) :: genPath(anotherFunc, global) :: List[SvgGraph]()).map(_.render) foreach println

  }

  def genPath(origin: ClassDiagram, dest: ClassDiagram) =
    Path(Point(origin.origin.x + origin.headerSize.width - 20, origin.origin.y + 15),
      dest.origin.copy(y = dest.origin.y + dest.headerSize.height / 2))
}
