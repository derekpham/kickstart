package models.plays

import models.AbstractPlay
import models.validation.Validator

import scala.sys.process._

class PackageInstall(packageNames: Iterable[String], validators: List[Validator] = List())
  extends AbstractPlay(validators) {

  override def actuallyExecute(): Unit = {
    val process = Process(getCommand) // TODO fix the command
    process.lazyLines.foreach(println)
  }

  override def dryRun(): Unit = {
    println(s"Would have run: '$getCommand'")
  }

  override def validate(): Unit = {
    validators.foreach(_.validate())
  }

  private def getCommand: String = {
    "pacman -S " + packageNames.mkString(" ")
  }
}
