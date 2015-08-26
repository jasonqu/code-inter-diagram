package svg

class SvgConvertor[Builder, Output <: FragT, FragT]
(val bundle: scalatags.generic.Bundle[Builder, Output, FragT], name: String) {

  import bundle.implicits._
  import bundle.svgAttrs._
  import bundle.svgTags._


  /*
      <g id="num0" transform="translate(100,100)">
        <rect class="wrapper" x="0" y="0" width="120" height="60"></rect>
        <g>
            <rect x="0" y="0" width="120" height="30" fill="rgba(0,0,255,0.5)" stroke-width="1" stroke="Black"></rect>
            <text class="header" x="60" y="20" text-anchor="middle" fill="white">Add</text>
        </g>
        <g transform="translate(0,30)">
            <rect x="0" y="0" width="60" height="30" fill="rgba(0,0,255,0.1)" stroke-width="1" stroke="Black"></rect>
            <text x="30" y="20" text-anchor="middle" fill="black">[[scope]]</text>
            <rect x="60" y="0" width="60" height="30" fill="rgba(0,0,255,0.1)" stroke-width="1" stroke="Black"></rect>
            <text x="90" y="20" text-anchor="middle" fill="black"></text>
        </g>
    </g>
   */
  /*
  svg rect.wrapper {
	fill: white;
	stroke: black;
	stroke-width: 3;
    filter: url(#f3);
}

cd: ClassDiagram
   */

  //def generateClassDiagram(elemId: String, origin: Point, size: Size, fillColor: String, contents: Map[String, String]) = {
  def generateClassDiagram(cd: ClassDiagram) =
    g(
      id := cd.elemId,
      transform := s"""translate(${cd.origin.x},${cd.origin.y})""")(
        // wrapper
        rect(x := 0, y := 0, `class` := "wrapper",
          width := cd.header.size.width, height := cd.header.size.height,
          fill := "white", stroke := "black",
          strokeWidth := 3),
        generateRectText(cd.header),
        for (myrect <- cd.rectangles) yield generateRectText(myrect)
        //      cd.rectangles.map(generateRectText):_*
        //      for (myrect <- cd.rectangles) yield g(
        //        rect(
        //          x := myrect.origin.x, y := myrect.origin.y,
        //          width := myrect.size.width,
        //          height := myrect.size.height,
        //          fill := myrect.fillColor,
        //          strokeWidth := 1,
        //          stroke := "Black"
        //        ),
        //        text(
        //          x := myrect.origin.x + myrect.size.width / 2, y := (myrect.origin.y + myrect.size.height - 8),
        //          textAnchor := "middle",
        //          fill := "Black",
        //          myrect.content
        //        )
        //      )
      )

  /*
  RectText(Point(0,0), Size(60, 30), "rgba(0,0,255,0.1)", "[[scope]]")
            <rect x="0" y="0" width="60" height="30" fill="rgba(0,0,255,0.1)" stroke-width="1" stroke="Black"></rect>
            <text x="30" y="20" text-anchor="middle" fill="black">[[scope]]</text>
   */
  //  def imgBox(source: String, text: String) = g(
  //    rect()
  //  )

  def generateRectText(rectangle: RectAngleWithText) =
    g(
      rect(
        x := rectangle.origin.x, y := rectangle.origin.y,
        width := rectangle.size.width,
        height := rectangle.size.height,
        fill := rectangle.fillColor,
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


object SvgConvertor {
  val convertor = new SvgConvertor(scalatags.Text, "svg")

  def genRectText(rect: RectAngleWithText): String =
    convertor.generateRectText(rect).render

  def genClassDiagram(cd: ClassDiagram): String = {
    convertor.generateClassDiagram(cd).render
  }
}