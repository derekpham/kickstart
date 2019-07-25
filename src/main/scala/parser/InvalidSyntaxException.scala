package parser

case class InvalidSyntaxException(message: String, private val cause: Throwable = None.orNull)
  extends Exception(message, cause)
