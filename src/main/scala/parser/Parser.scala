package parser

import java.util

import models.{Play, Playbook}
import org.yaml.snakeyaml.Yaml
import parser.play.PackageInstallParser

import scala.jdk.CollectionConverters._

object Parser {
  def parse(rawPlayBook: String): Playbook = {
    val yaml = new Yaml()
    val rawPlays = yaml.load(rawPlayBook).asInstanceOf[util.ArrayList[Any]].asScala
    new Playbook(rawPlays.map(_.asInstanceOf[util.Map[String, Any]]).map(parsePlay))
  }

  private def parsePlay(rawObj: util.Map[String, Any]): Play = {
    if (rawObj.size() != 1) {
      throw InvalidSyntaxException("Each play must have one top level item only")
    }

    val playName = rawObj.keySet().asScala.head
    val playValue = rawObj.get(playName).asInstanceOf[util.Map[String, Any]]
    playName match {
      case "install" => PackageInstallParser.parse(playValue)
      case illegalPlayName => throw InvalidSyntaxException(s"Illegal play name: $illegalPlayName")
    }
  }
}
