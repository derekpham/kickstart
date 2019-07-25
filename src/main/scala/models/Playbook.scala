package models

class Playbook(plays: Iterable[Play]) {

  def execute(dryRun: Boolean): Unit = {
    plays.foreach(_.execute(dryRun))
  }
}
