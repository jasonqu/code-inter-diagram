package cid

import spray.json.DefaultJsonProtocol._
import spray.json.JsonFormat

/**
 * Created by jasonqu on 2015/8/21.
 */
package object json {
  implicit val blocksFormat: JsonFormat[Blocks] = lazyFormat(jsonFormat(Blocks, "min", "max", "children"))

}
