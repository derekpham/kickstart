package models

import models.validation.Validator

abstract class AbstractPlay(validators: List[Validator]) extends Play {
  override def validate(): Unit = {
    if (validators.isEmpty) {
      println("No validation to be performed.")
    } else {
      validators.foreach(_.validate())
    }
  }
}
