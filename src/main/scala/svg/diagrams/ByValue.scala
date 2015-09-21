package svg.diagrams

import svg._

object ByValue extends App {
  val headersize = Size(150, 30)
  val val1 = ClassDiagram("num1", Point(100, 100), headersize, "复制前", "rgba(0, 102, 255, 0.5)",
    ("", "") ::("", "") ::("a", "1") :: Nil)
  val val2 = ClassDiagram("num2", Point(300, 100), headersize, "复制后", "rgba(51, 204, 51, 0.5)",
    ("", "") :: ("b", "1") :: ("a", "1") :: Nil)
  val val3 = ClassDiagram("num3", Point(500, 100), headersize, "修改b的值", "rgba(255, 0, 102, 0.5)",
    ("", "") :: ("b", "2") :: ("a", "1") :: Nil)

  (val1::val2 ::val3::Nil).map(_.render) foreach println
}
