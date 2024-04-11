package com.example.practiceapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var userInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

            userInput = findViewById(R.id.username_input)
            passwordInput= findViewById(R.id.password_input)
            loginButton= findViewById(R.id.login_btn)

            loginButton.setOnClickListener{
                val username  =userInput.text.toString()
                val password  =passwordInput.text.toString()

                loginButton.setOnClickListener {
                    val username = userInput.text.toString()
                    val password = passwordInput.text.toString()

                    if (username.length > 6 && !username.containsDigits()) {
                        if (password.length > 6 && password.containsDigits() && password.containsCharacters()) {
                            Log.i("test credentials", "username:$username and password:$password")
                        } else {
                            when {
                                password.length <= 6 -> {
                                    Toast.makeText(this, "Password should contain more than six characters", Toast.LENGTH_SHORT).show()
                                }
                                !password.containsDigits() || !password.containsCharacters() -> {
                                    Toast.makeText(this, "Password must contain both digits and characters", Toast.LENGTH_SHORT).show()
                                }

                            }
                        }
                    } else {
                        when {
                            username.length <= 6 -> {
                                Toast.makeText(this, "Username should contain more than six characters", Toast.LENGTH_SHORT).show()
                            }
                            username.containsDigits() -> {
                                Toast.makeText(this, "Username must contain only characters", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }

            }
    }
}
fun String.containsDigits(): Boolean {
    return any { it.isDigit() }
}

fun String.containsCharacters():Boolean{
    return any{it.isLetter()}
}