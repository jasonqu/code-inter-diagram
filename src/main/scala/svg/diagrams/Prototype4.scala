package svg.diagrams

import svg._

object Prototype4 extends App {
  val headersize = Size(180, 30)

  //val objFunc = ClassDiagram("Object", Point(360, 400), headersize, "Object", "rgba(51, 204, 51, 0.5)", ("prototype", "") :: Nil)
  val personFunc = ClassDiagram("person", Point(100, 100), headersize, "Person", "rgba(51, 204, 51, 0.5)",
    ("prototype", "") :: Nil)
  //val citizenFunc = ClassDiagram("citizen", Point(100, 250), headersize, "Citizen", "rgba(51, 204, 51, 0.5)", ("prototype", "") :: Nil)

  val citizen = ClassDiagram("american", Point(100, 250), headersize, "american", "rgba(0, 102, 255, 0.5)",
    ("__proto__", "") :: ("nationality", "USA") :: Nil)



  val objproto = ClassDiagram("objproto", Point(650, 150), Size(220, 30), "Object.prototype", "rgba(255, 153, 0, 0.5)",
    ("__proto__", "null") :: ("constructor", "Object"):: ("hasOwnProperty", "(function)") ::
      ("isPrototypeOf", "(function)") :: ("toString", "(function)") ::
      ("...", "..."):: Nil)

  val personProto = ClassDiagram("personProto", Point(360, 100), headersize, "Person.prototype", "rgba(255, 153, 0, 0.5)",
    ("__proto__", "") :: ("constructor", "Person") :: Nil)
  val citizenProto = ClassDiagram("citizenProto", Point(360, 250), headersize, "Citizen.prototype", "rgba(255, 153, 0, 0.5)",
    ("__proto__", ""):: ("constructor", "Citizen") :: Nil)

  val path1 = Path(Point(495, 145), Point(650, 152))
  val path3 = Path(Point(495, 295), Point(650, 165))

  //val path4 = Path(Point(235, 145), Point(360, 115))
  val path5 = Path(Point(235, 295), Point(360, 265))
  // 还有一条
  //  <path d="M235,145 H297 V205 H60 V265 H92" class="connecting"></path>
  (personFunc::citizen::objproto::personProto::citizenProto ::
    path1 :: path3 :: path5 :: List[SvgGraph]()).map(_.render) foreach println
}
