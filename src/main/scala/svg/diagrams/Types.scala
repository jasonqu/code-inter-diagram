package svg.diagrams

import svg._

object Types extends App {
  val headersize = Size(150, 30)
  val graphs =
    RectAngleWithText(Point(100, 360), headersize, "rgba(0, 102, 255, 0.5)", "Javascript对象", 1, "header") ::
      Path(Point(250, 375), Point(300, 215)) ::
      Path(Point(250, 375), Point(300, 540)) ::
      RectAngleWithText(Point(300, 200), headersize, "rgba(255, 153, 0, 0.5)", "值类型", 1, "content") ::
      RectAngleWithText(Point(300, 525), headersize, "rgba(255, 153, 0, 0.5)", "引用类型", 1, "content") ::
      Path(Point(450, 215), Point(500, 115)) ::
      Path(Point(450, 215), Point(500, 165)) ::
      Path(Point(450, 215), Point(500, 215)) ::
      Path(Point(450, 215), Point(500, 265)) ::
      Path(Point(450, 215), Point(500, 315)) ::
      RectAngleWithText(Point(500, 100), headersize, "rgba(51, 204, 51, 0.5)", "Number数字", 1, "header") ::
      RectAngleWithText(Point(500, 150), headersize, "rgba(51, 204, 51, 0.5)", "String字符串", 1, "header") ::
      RectAngleWithText(Point(500, 200), headersize, "rgba(51, 204, 51, 0.5)", "Boolean布尔", 1, "header") ::
      RectAngleWithText(Point(500, 250), headersize, "rgba(51, 204, 51, 0.5)", "Null", 1, "header") ::
      RectAngleWithText(Point(500, 300), headersize, "rgba(51, 204, 51, 0.5)", "Undefined", 1, "header") ::
      Path(Point(650, 115), Point(700, 85)) ::
      Path(Point(650, 115), Point(700, 145)) ::
      Path(Point(650, 265), Point(700, 265)) ::
      Path(Point(650, 315), Point(700, 315)) ::
      RectAngleWithText(Point(700, 70), headersize, "rgba(255, 0, 102, 0.5)", "NaN 非数字", 1, "content") ::
      RectAngleWithText(Point(700, 130), headersize, "rgba(255, 0, 102, 0.5)", "Infinity 无限大", 1, "content") ::
      RectAngleWithText(Point(700, 250), headersize, "rgba(255, 0, 102, 0.5)", "null", 1, "content") ::
      RectAngleWithText(Point(700, 300), headersize, "rgba(255, 0, 102, 0.5)", "undefined", 1, "content") ::
      Path(Point(450, 540), Point(500, 415)) ::
      Path(Point(450, 540), Point(500, 465)) ::
      Path(Point(450, 540), Point(500, 515)) ::
      Path(Point(450, 540), Point(500, 565)) ::
      Path(Point(450, 540), Point(500, 615)) ::
      Path(Point(450, 540), Point(500, 665)) ::
      RectAngleWithText(Point(500, 400), headersize, "rgba(51, 204, 51, 0.5)", "Object 对象", 1, "header") ::
      RectAngleWithText(Point(500, 450), headersize, "rgba(51, 204, 51, 0.5)", "Function 函数", 1, "header") ::
      RectAngleWithText(Point(500, 500), headersize, "rgba(51, 204, 51, 0.5)", "Array 数组", 1, "header") ::
      RectAngleWithText(Point(500, 550), headersize, "rgba(51, 204, 51, 0.5)", "Date 日期", 1, "header") ::
      RectAngleWithText(Point(500, 600), headersize, "rgba(51, 204, 51, 0.5)", "RegExp 正则", 1, "header") ::
      RectAngleWithText(Point(500, 650), headersize, "rgba(51, 204, 51, 0.5)", "Error 错误", 1, "header") ::
      Path(Point(650, 665), Point(700, 665)) ::
      RectAngleWithText(Point(700, 575), headersize, "rgba(255, 0, 102, 0.5)", "EvalError", 1, "content") ::
      RectAngleWithText(Point(700, 605), headersize, "rgba(255, 0, 102, 0.5)", "RangeError", 1, "content") ::
      RectAngleWithText(Point(700, 635), headersize, "rgba(255, 0, 102, 0.5)", "ReferenceError", 1, "content") ::
      RectAngleWithText(Point(700, 665), headersize, "rgba(255, 0, 102, 0.5)", "SyntaxError", 1, "content") ::
      RectAngleWithText(Point(700, 695), headersize, "rgba(255, 0, 102, 0.5)", "TypeError", 1, "content") ::
      RectAngleWithText(Point(700, 725), headersize, "rgba(255, 0, 102, 0.5)", "URIError", 1, "content") ::
      Nil

  graphs.map(_.render) foreach println
}
