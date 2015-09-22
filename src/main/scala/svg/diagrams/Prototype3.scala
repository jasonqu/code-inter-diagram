package svg.diagrams

import svg._

object Prototype3 extends App {
  val headersize = Size(180, 30)

  val objFunc = ClassDiagram("Object", Point(360, 400), headersize, "Object", "rgba(51, 204, 51, 0.5)", ("prototype", "") :: Nil)
  val personFunc = ClassDiagram("person", Point(100, 100), headersize, "Person", "rgba(51, 204, 51, 0.5)",
    ("prototype", "") :: Nil)
  val citizenFunc = ClassDiagram("citizen", Point(100, 250), headersize, "Citizen", "rgba(51, 204, 51, 0.5)", ("prototype", "") :: Nil)




  val objproto = ClassDiagram("objproto", Point(650, 150), Size(220, 30), "Object.prototype", "rgba(255, 153, 0, 0.5)",
    ("__proto__", "null") :: ("constructor", ""):: ("hasOwnProperty", "(function)") ::
      ("isPrototypeOf", "(function)") :: ("toString", "(function)") ::
      ("...", "..."):: Nil)

  val personProto = ClassDiagram("personProto", Point(360, 100), headersize, "Person.prototype", "rgba(255, 153, 0, 0.5)",
    ("__proto__", "") :: ("constructor", "") :: Nil)
  val citizenProto = ClassDiagram("citizenProto", Point(360, 250), headersize, "Citizen.prototype", "rgba(255, 153, 0, 0.5)",
    ("__proto__", ""):: ("constructor", "") :: Nil)

  val path1 = Path(Point(495, 145), Point(650, 152))
  val path2 = Path(Point(495, 445), Point(650, 178), 10)
  val path3 = Path(Point(495, 295), Point(650, 165))

  val path4 = Path(Point(235, 145), Point(360, 115))
  val path5 = Path(Point(235, 295), Point(360, 265))
  // 还有一条
  // <path d="M815,225 H900 V480 H310 V415 H352" class="connecting"></path>
  // <path d="M495,175 H560 V220 H60 V115 H92" class="connecting"></path>
  // <path d="M495,325 H560 V360 H60 V265 H92" class="connecting"></path>

  (objFunc::personFunc::citizenFunc::objproto::personProto::citizenProto ::
    path1 :: path2 :: path3 :: path4 :: path5 :: List[SvgGraph]()).map(_.render) foreach println
}
