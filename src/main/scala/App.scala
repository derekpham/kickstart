import org.yaml.snakeyaml.Yaml
import parser.Parser

import scala.io.Source

object App {
  def main(args: Array[String]): Unit = {
    val playbookFilePath = args.head
    val rawPlayBook = Source.fromFile(playbookFilePath).mkString
    val yamlPlaybook = new Yaml()
    yamlPlaybook.load(rawPlayBook)

    Parser.parse(yamlPlaybook).execute()
  }
}
