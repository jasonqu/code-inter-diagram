package svg


object Output extends App {
  val color = "rgba(0,0,255,0.5)"
  val headersize = Size(120, 30)
  val add = ClassDiagram("num0", Point(100, 100), headersize, "Add", color, ("[[scope]]", "") :: Nil)
  val scope = ClassDiagram("num1", Point(300, 100), headersize, "Scope Chain", color, ("0", "") :: Nil)
  val act = ClassDiagram("num2", Point(500, 100), headersize, "Global object", color,
    ("this", "window") :: ("window", "(object)") :: ("add", "(function)") :: Nil)


  val path1 = Path(Point(190,145), Point(300, 115))
  val path2 = Path(Point(390,145), Point(500, 115))

  (add :: scope :: act :: path1 :: path2 :: List[SvgGraph]()).map(_.render) foreach println
}
