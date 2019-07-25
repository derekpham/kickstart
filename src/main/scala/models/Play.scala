package models

trait Play {
  def actuallyExecute(): Unit
  def dryRun(): Unit

  def execute(dryRun: Boolean = false): Unit = {
    if (dryRun) {
      this.dryRun()
    } else {
      this.actuallyExecute()
    }
  }
}
