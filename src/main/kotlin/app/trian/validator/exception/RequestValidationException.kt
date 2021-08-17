package app.trian.validator.exception

import app.trian.validator.ValidationResult

class RequestValidationException(val validationResult: ValidationResult) : RuntimeException()