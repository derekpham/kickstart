package models.validation

class SimpleValidator(validatorName: String, validationSteps: List[ValidationStep]) extends Validator {
  override def validate(): Unit = {
    validationSteps.foreach(_.validate())
  }
}
