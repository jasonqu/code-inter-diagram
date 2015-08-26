package svg

class SvgConverter[Builder, Output <: FragT, FragT]
(val bundle: scalatags.generic.Bundle[Builder, Output, FragT], name: String) {

  import bundle.implicits._
  import bundle.svgAttrs._
  import bundle.svgTags._

  def generateClassDiagram(cd: ClassDiagram) =
    g(
      id := cd.elemId,
      transform := s"""translate(${cd.origin.x},${cd.origin.y})""")(
        // wrapper
        rect(x := 0, y := 0, `class` := "wrapper",
          width := cd.header.size.width, height := cd.header.size.height * (cd.size + 1)),
        generateRectText(cd.header)
      )

  def generateRectText(rectangle: RectAngleWithText) =
    g(
      rect(
        `class` := rectangle.`class`,
        x := rectangle.origin.x, y := rectangle.origin.y,
        width := rectangle.size.width,
        height := rectangle.size.height,
        fill := rectangle.fillColor,
        fillOpacity := rectangle.opacity,
        strokeWidth := 1,
        stroke := "Black"
      ),
      text(
        x := rectangle.origin.x + rectangle.size.width / 2, y := (rectangle.origin.y + rectangle.size.height - 8),
        textAnchor := "middle",
        fill := "Black",
        rectangle.content
      )
    )
}


object SvgConverter {
  val converter = new SvgConverter(scalatags.Text, "svg")

  def genRectText(rect: RectAngleWithText): String =
    converter.generateRectText(rect).render

  def genClassDiagram(cd: ClassDiagram): String = {
    val header = converter.generateClassDiagram(cd).render
    s"""${header.substring(0, header.size - 4)}
        |${cd.rectangles.map(genRectText).mkString("\n")}
        |</g>
     """.stripMargin
  }
}