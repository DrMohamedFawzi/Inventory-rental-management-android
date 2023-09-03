package com.msnit.inventoryrentalmanagement

import FirstFragment
import SecondFragment
import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class main_screen : AppCompatActivity() {
    private lateinit var listView: ListView

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            showCustomDialog()
        }



        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    loadFragment(FirstFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.Search -> {
                    loadFragment(SecondFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.placeholder -> {
                    // اعمل شيئًا ما أو قم بإجراء إضافي
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.person -> {
                    loadFragment(FirstFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.settings -> {
                    loadFragment(FirstFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }

        // تحميل الفراغ الفرعي الأول عند بدء التطبيق
        loadFragment(FirstFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        val fm: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.flFragment, fragment)
        fragmentTransaction.commit()
    }

    private fun showCustomDialog() {
        val customDialog = CustomDialog()
        customDialog.show(supportFragmentManager, "CustomDialog")
    }
}