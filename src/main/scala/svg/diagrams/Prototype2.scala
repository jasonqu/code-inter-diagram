package svg.diagrams

import svg._

object Prototype2 extends App {
  val headersize = Size(180, 30)

  val objFunc = ClassDiagram("Object", Point(100, 400), headersize, "Object", "rgba(51, 204, 51, 0.5)", ("prototype", "") :: Nil)
  val person = ClassDiagram("person", Point(100, 100), headersize, "person", "rgba(0, 102, 255, 0.5)",
    ("__proto__", "") :: ("name", "Brendan Eich") :: Nil)
  val objproto = ClassDiagram("objproto", Point(450, 150), Size(220, 30), "Object.prototype", "rgba(255, 153, 0, 0.5)",
    ("__proto__", "null") :: ("constructor", ""):: ("hasOwnProperty", "(function)") ::
      ("isPrototypeOf", "(function)") :: ("toString", "(function)") ::
      ("...", "...") ::("sayName", "(function)"):: Nil)

  val obj = ClassDiagram("obj", Point(100, 200), headersize, "obj", "rgba(0, 102, 255, 0.5)",
    ("__proto__", "") :: ("name", "unknown") :: Nil)
  val obj2 = ClassDiagram("obj2", Point(100, 300), headersize, "obj2", "rgba(0, 102, 255, 0.5)",
    ("__proto__", "") :: Nil)

  val path1 = Path(Point(235, 145), Point(450, 152))
  val path3 = Path(Point(235, 245), Point(450, 160), -10)
  val path4 = Path(Point(235, 345), Point(450, 169))
  val path2 = Path(Point(235, 445), Point(450, 178), 10)
  // 还有一条
  // <path d="M615,225 H700 V480 H50 V415 H92" class="connecting"></path>

  (objFunc::person::objproto::obj::obj2 :: path1 :: path2 :: path4 :: path3 :: List[SvgGraph]()).map(_.render) foreach println
}
