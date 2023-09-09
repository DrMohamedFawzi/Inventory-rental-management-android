package com.msnit.inventoryrentalmanagement

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.msnit.inventoryrentalmanagement.db.RentalDatabase
import com.msnit.inventoryrentalmanagement.login.Login
import com.msnit.inventoryrentalmanagement.login.splash
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configure window to full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Show progress dialog


        GlobalScope.launch(Dispatchers.IO) {
            val rentalDatabase = RentalDatabase.getInstance(applicationContext)
            val hasData = rentalDatabase.utilDao().hasData()

            // Delay for 2000 milliseconds (2 seconds)
            Thread.sleep(2000)

            // Dismiss progress dialog


            // Start appropriate activity based on data availability
            val intent = if (hasData) {
                Intent(applicationContext, Login::class.java)
            } else {
                Intent(applicationContext, splash::class.java)
            }
            startActivity(intent)
            finish()
        }
    }
}