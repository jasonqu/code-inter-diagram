package svg


object Output extends App {
  println(ClassDiagram("id", Point(100, 100), Size(120, 30), "Add", "rgba(0,0,255,0.5)", ("[[scope]]", "") :: Nil).render)
}
