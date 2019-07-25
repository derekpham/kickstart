package models

class Playbook(plays: Iterable[Play]) {

  def execute(): Unit = {
    plays.foreach(_.execute)
  }
}
