package com.backmarket.multiplaform.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.backmarket.multiplaform.shared.Greeting
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.backmarket.multiplaform.shared.form.PASSWORD_ERROR_MESSAGE
import com.backmarket.multiplaform.shared.form.PASSWORD_SUCCESS_MESSAGE
import com.backmarket.multiplaform.shared.form.PasswordValidationUseCase

class MainActivity : AppCompatActivity() {

    // region UI
    private val tv: TextView by lazy { findViewById(R.id.text_view) }
    private val password: TextView by lazy { findViewById(R.id.password) }
    private val button: Button by lazy { findViewById(R.id.button) }
    // endregion

    // region Data
    private val greetingMessage =
        Greeting().greeting() // <- Shared logic class
    private val isPasswordValid =
        PasswordValidationUseCase() // <- Shared logic class
    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv.text = greetingMessage





        button.setOnClickListener {
            if (isPasswordValid(password.text.toString())) {
                Toast.makeText(this, PASSWORD_SUCCESS_MESSAGE, LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, PASSWORD_ERROR_MESSAGE, LENGTH_SHORT).show()
            }
        }
    }
}
