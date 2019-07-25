package models.plays

import models.AbstractPlay
import models.validation.Validator

class Dotfiles(versionControlLink: String, validators: List[Validator]) extends AbstractPlay(validators) {
  override def actuallyExecute(): Unit = {

  }

  override def dryRun(): Unit = {
    println(s"Would have downloaded dotfiles from $versionControlLink ...")
    println(s"Would have run 'stow' on downloaded files ...")
  }
}
