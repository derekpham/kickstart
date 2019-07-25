package parser

import models.validation.Validator

import scala.jdk.CollectionConverters._

object ValidatorParser {
  def parse(rawValidators: java.util.List[Any]): List[Validator] = {
    rawValidators.asScala
      .map(_.asInstanceOf[java.util.Map[String, List[Map[String, String]]]])
      .map(ParseUtils.mapToOneKeyValuePair(_))

  }

  def parseValidator(validatorName: String, validatorRawValues: List[Map[String, String]]): Validator = {

  }
}
