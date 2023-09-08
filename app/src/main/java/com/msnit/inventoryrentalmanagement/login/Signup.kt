package com.msnit.inventoryrentalmanagement.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.msnit.inventoryrentalmanagement.R

class Signup : AppCompatActivity() {

    private val delayDuration: Long = 1000 // 5 seconds
    private val USER_NAME_ID:String = "username_id";
    private val PASSWORD_ID:String = "password_id";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val handler = android.os.Handler()

        handler.postDelayed({
            // تنفيذ الانتقال إلى الواجهة الأخرى هنا
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish() // اختياري: إغلاق الواجهة الحالية إذا لم تكن بحاجة إليها
        }, delayDuration)
    }
}