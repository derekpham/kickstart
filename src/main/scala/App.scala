import parser.Parser

import scala.io.Source

object App {
  def main(args: Array[String]): Unit = {
    val rawPlayBook = Source.fromFile(args.head).mkString
    Parser.parse(rawPlayBook).execute(true)
  }
}
