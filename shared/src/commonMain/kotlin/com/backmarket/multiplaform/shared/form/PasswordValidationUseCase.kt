package com.backmarket.multiplaform.shared.form

class PasswordValidationUseCase {
    operator fun invoke(password: String) =
        password.length >= PASSWORD_MIN_LENGTH
}