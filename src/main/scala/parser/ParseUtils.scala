package parser

import scala.jdk.CollectionConverters._

object ParseUtils {
  def mapToOneKeyValuePair[T](map: java.util.Map[String, T]): (String, T) = {
    if (map.size() != 1) {
      throw InvalidSyntaxException(s"Invalid syntax. There can only be 1 key value pair $map")
    }

    (map.keySet().asScala.head, map.values().asScala.head)
  }
}
