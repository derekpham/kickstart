package models

trait Play {
  def actuallyExecute(): Unit
  def dryRun(): Unit
  def validate(): Unit

  def execute(dryRun: Boolean = false): Unit = {
    if (dryRun) {
      this.dryRun()
    } else {
      this.actuallyExecute()
      this.validate()
    }
  }
}
