package com.example.calculatorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorapp.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        loadFragment(CalcFragment())
        var bottomNav = binding.bottomNavigation
        bottomNav.setOnNavigationItemSelectedListener  {
            when (it.itemId) {
                R.id.page_1 -> {
                    loadFragment(CalcFragment())
                    true
                }
                R.id.page_2 -> {
                    loadFragment(ConvFragment())
                    true
                }
                R.id.page_3 -> {
                    loadFragment(ImcFragment())
                    true
                }
             else -> false
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_fragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}