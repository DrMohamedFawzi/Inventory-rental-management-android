package com.msnit.inventoryrentalmanagement

import FirstFragment
import SecondFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class main_screen : AppCompatActivity() {
    private lateinit var firstFragment: Button
    private lateinit var secondFragment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        // الحصول على مراجع الأزرار
        firstFragment = findViewById(R.id.firstFragment)
        secondFragment = findViewById(R.id.secondFragment)

        // تعيين مستمع للنقر على الزر الأول
        firstFragment.setOnClickListener(View.OnClickListener {
            // تحميل الفراغ الفرعي الأول
            loadFragment(FirstFragment())
        })

        // تعيين مستمع للنقر على الزر الثاني
        secondFragment.setOnClickListener(View.OnClickListener {
            // تحميل الفراغ الفرعي الثاني
            loadFragment(SecondFragment())
        })
    }

    private fun loadFragment(fragment: Fragment) {
        // إنشاء FragmentManager
        val fm: FragmentManager = supportFragmentManager
        // إنشاء FragmentTransaction لبدء العملية واستبدال الفراغ الفرعي
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
        // استبدال FrameLayout بـ Fragment جديد
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit() // حفظ التغييرات
    }
}