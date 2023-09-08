package com.msnit.inventoryrentalmanagement.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.msnit.inventoryrentalmanagement.R
import com.msnit.inventoryrentalmanagement.MainScreen

class Login : AppCompatActivity() {

    private val delayDuration: Long = 1000 // 5 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val handler = android.os.Handler()

        handler.postDelayed({
            // تنفيذ الانتقال إلى الواجهة الأخرى هنا
            val intent = Intent(this, MainScreen::class.java)
            startActivity(intent)
            finish() // اختياري: إغلاق الواجهة الحالية إذا لم تكن بحاجة إليها
        }, delayDuration)
    }
}
