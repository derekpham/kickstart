package models.validation

trait ValidationStep {
  def validationDescription(): String
  def validate(): Unit
}
