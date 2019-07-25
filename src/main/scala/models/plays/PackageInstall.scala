package models.plays

import models.Play
import sys.process._

class PackageInstall(packageNames: Iterable[String]) extends Play {

  override def actuallyExecute(): Unit = {
    val process = Process(getCommand) // TODO fix the command
    process.lazyLines.foreach(println)
  }

  override def dryRun(): Unit = {
    println(s"Would have run: '$getCommand'")
  }

  private def getCommand: String = {
    "pacman -S " + packageNames.mkString(" ")
  }
}
