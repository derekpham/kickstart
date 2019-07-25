package parser.play

import models.plays.PackageInstall
import parser.InvalidSyntaxException

import scala.jdk.CollectionConverters._

object PackageInstallParser {
  def parse(playValue: java.util.Map[String, Any]): PackageInstall = {
    val packageNames: Iterable[String] = Option(playValue.get("packages"))
      .getOrElse(() => throw InvalidSyntaxException("Must specify packages to install"))
      .asInstanceOf[java.util.List[String]]
      .asScala

    new PackageInstall(packageNames)
  }
}
