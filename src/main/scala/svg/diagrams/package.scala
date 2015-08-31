package svg

package object diagrams {
  def genPath(origin: ClassDiagram, dest: ClassDiagram) =
    Path(Point(origin.origin.x + origin.headerSize.width - 20, origin.origin.y + 15),
      dest.origin.copy(y = dest.origin.y + dest.headerSize.height / 2))
}
