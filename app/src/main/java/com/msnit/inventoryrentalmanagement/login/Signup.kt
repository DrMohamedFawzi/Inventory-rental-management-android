package com.msnit.inventoryrentalmanagement.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.msnit.inventoryrentalmanagement.R
import com.msnit.inventoryrentalmanagement.db.RentalDatabase
import com.msnit.inventoryrentalmanagement.db.entity.UtilEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Signup : AppCompatActivity() {
    private val delayDuration: Long = 7000 // 5 seconds
    private lateinit var editTextName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextConfirmPassword: EditText
    private lateinit var buttonSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Initialize views
        editTextName = findViewById(R.id.editTextName)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPasswords)
        buttonSignup = findViewById(R.id.button)

        // Set click listener for the signup button
        // Set click listener for the signup button
        buttonSignup.setOnClickListener {
            val name = editTextName.text.toString()
            val password = editTextPassword.text.toString()
            val confirmPassword = editTextConfirmPassword.text.toString()

            if (name.isNotEmpty() && password.isNotEmpty() && password == confirmPassword) {
                // Create a UtilEntity object
                val utilEntity = UtilEntity(name = name, value = password)

                // Insert the UtilEntity into the database using the UtilDao
                GlobalScope.launch(Dispatchers.IO) {
                    val rentalDatabase = RentalDatabase.getInstance(applicationContext)
                    val utilDao = rentalDatabase.utilDao()
                    utilDao.insert(utilEntity)
                }

                // Handle successful signup
                Toast.makeText(applicationContext, "تم التسجيل بنجاح!", Toast.LENGTH_SHORT).show()
                val handler = android.os.Handler()
                handler.postDelayed({
                    // Perform the transition to another activity here
                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                    finish() // Optional: Close the current activity if not needed
                }, delayDuration)

            } else {
                // Handle invalid input
                Toast.makeText(applicationContext, "خطأ في الإدخال!", Toast.LENGTH_SHORT).show()
            }
        }}}