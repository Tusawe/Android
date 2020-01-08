package com.dinterfaces.examen_gomez_joseluis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    var fragmentForm = EventFormFragment()
    var fragmentList = EventListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun setDefaultFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, fragmentList)
            .commit()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.eventList-> {
                changeFragment(fragmentList)
                true
            }
            R.id.eventForm -> {
                changeFragment(fragmentForm)
                true
            }
            else -> true
        }


    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

}



