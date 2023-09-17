package com.msnit.inventoryrentalmanagement

import AddItemDialog
import SecondFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.msnit.inventoryrentalmanagement.items.ItemsFragment

class MainScreen : AppCompatActivity() {
    private var activeFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            showCustomDialog()
        }


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    loadFragment(ItemsFragment())
                    true
                }

                R.id.Search -> {
                    loadFragment(SecondFragment())
                    true
                }

                R.id.person -> {
                    loadFragment(ItemsFragment())
                    true
                }

                R.id.settings -> {
                    loadFragment(ItemsFragment())
                    true
                }

                else -> false
            }
        }

        // تحميل الفراغ الفرعي الأول عند بدء التطبيق
        loadFragment(ItemsFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        val fm: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.flFragment, fragment)
        fragmentTransaction.commit()
        activeFragment = fragment

    }

    private fun showCustomDialog() {
        when (activeFragment) {
            is ItemsFragment -> {
                val itemsFragment = activeFragment as? ItemsFragment
                if (itemsFragment != null) {
                    val addItemDialog = AddItemDialog { item ->
                        itemsFragment.addItem(item)
                    }
                    addItemDialog.show(supportFragmentManager, "CustomDialog")
                }
            }
        }
    }

}