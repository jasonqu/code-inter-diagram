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
   */

  def ClassDiagram(elemId: String, origin: Point, size: Size, fillColor: String, contents: Map[String, String]) = {
    g(
      id := elemId,
      transform := s"""translate(${origin.x},${origin.y})""",
      rect(x := 0, y := 0,
        width := size.width, height := 30,
        fill := "white", stroke := "black",
        strokeWidth := 3)//, filter := "url(#f3)")
      //    <rect class="wrapper" x="0" y="0" width="120" height="60"></rect>
    )
  }

  /*
  RectText(Point(0,0), Size(60, 30), "rgba(0,0,255,0.1)", "[[scope]]")
            <rect x="0" y="0" width="60" height="30" fill="rgba(0,0,255,0.1)" stroke-width="1" stroke="Black"></rect>
            <text x="30" y="20" text-anchor="middle" fill="black">[[scope]]</text>
   */
  def RectText(origin: Point, size: Size, fillColor: String, content: String) = {
    g(
      rect(
        x := origin.x, y := origin.y,
        //        rx := 20, ry := 20,
        width := size.width,
        height := size.height,
        fill := fillColor,
        strokeWidth := 1,
        stroke := "Black"
        //        fillOpacity := "0.1",
        //        strokeOpacity := "0.5"
      ),
      text(
        x := origin.x + size.width / 2, y := (origin.y + size.height - 8),
        textAnchor := "middle",
        fill := "Black",
        //transform := "rotate(30 20, 40)",
        content
      )
    )
  }
}
