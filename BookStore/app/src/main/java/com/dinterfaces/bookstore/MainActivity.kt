package com.dinterfaces.bookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.fragment.app.Fragment
import com.dinterfaces.bookstore.LibrosSingleton.catalogo

class MainActivity : AppCompatActivity() {

    val fragmentList = ListaFragment()
    val fragmentForm = FormularioFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.container)

        if (currentFragment == null) {
            setDefaultFragment()
        }
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
            R.id.lista -> {
                changeFragment(fragmentList)
                true
            }
            R.id.formulario -> {
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
