package com.msnit.inventoryrentalmanagement.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.msnit.inventoryrentalmanagement.R
import com.msnit.inventoryrentalmanagement.MainScreen
import com.msnit.inventoryrentalmanagement.db.RentalDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Login : AppCompatActivity() {

    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val password = passwordEditText.text.toString()

            GlobalScope.launch(Dispatchers.IO) {
                val rentalDatabase = RentalDatabase.getInstance(applicationContext)
                val utilDao = rentalDatabase.utilDao()
                val savedPassword = utilDao.getValueByKey("password")?.value

                if (password == savedPassword) {
                    val intent = Intent(applicationContext, MainScreen::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    runOnUiThread {
                        Toast.makeText(applicationContext, "كلمة المرور غير صحيحة", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}