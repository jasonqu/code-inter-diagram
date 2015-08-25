package svg

object Output extends App {
  val svg = new SvgConvertor(scalatags.Text, "svg")
  println(svg.RectText(Point(0,0), Size(60, 30), "rgba(0,0,255,0.1)", "[[scope]]"))
  println(svg.ClassDiagram("", Point(0,0), Size(60, 30), "rgba(0,0,255,0.1)", Map("[[scope]]" -> "")))
}
