package models.validation

class ManualValidationStep(description: String) extends ValidationStep {
  override def validationDescription(): String = description

  override def validate(): Unit = {
    // TODO prompt the user and process y/n questions
  }
}
