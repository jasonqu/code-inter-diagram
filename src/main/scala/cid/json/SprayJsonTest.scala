package cid.json

import spray.json._
import DefaultJsonProtocol._
import cid._

object SprayJsonTest extends App {

  var blocks = Blocks(1, 31,
    Blocks(3, 18, List(
      Blocks(5, 9), Blocks(11, 16)
    )) :: Blocks(20, 28) :: Nil
  ).toJson

  println(blocks)
}
