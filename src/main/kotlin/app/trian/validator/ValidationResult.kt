package app.trian.validator

typealias PropertyPath = String
typealias ValidationError = String

sealed class ValidationResult {
    object NotValidated : ValidationResult()
    object Valid : ValidationResult()
    class Invalid(val errors: Map<PropertyPath, List<ValidationError>>) : ValidationResult()
}