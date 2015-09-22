package svg.diagrams

import svg._

object Prototype1 extends App {
  val headersize = Size(180, 30)

  val objFunc = ClassDiagram("Object", Point(100, 300), headersize, "Object", "rgba(51, 204, 51, 0.5)", ("prototype", "") :: Nil)
  val person = ClassDiagram("person", Point(100, 100), headersize, "person", "rgba(0, 102, 255, 0.5)",
    ("__proto__", "") :: ("name", "Brendan Eich") :: Nil)
  val objproto = ClassDiagram("objproto", Point(450, 150), Size(220, 30), "Object.prototype", "rgba(255, 153, 0, 0.5)",
    ("__proto__", "null") :: ("constructor", ""):: ("hasOwnProperty", "(function)") ::
      ("isPrototypeOf", "(function)") :: ("toString", "(function)") ::
      ("...", "...") :: Nil)

  val path1 = Path(Point(235, 145), Point(450, 160))
  val path2 = Path(Point(235, 345), Point(450, 170))
  // 还有一条
  // <path d="M615,225 H700 V400 H50 V315 H92" class="connecting"></path>

  (objFunc::person::objproto :: path1 :: path2 :: List[SvgGraph]()).map(_.render) foreach println
}
