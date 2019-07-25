package models.plays

import models.Play
import sys.process._

class PackageInstall(packageNames: Iterable[String]) extends Play {

  override def execute: Unit = {
    val all_packages = packageNames.mkString(" ")
    s"pacman -S $all_packages" !
    // TODO fix the command
  }
}
