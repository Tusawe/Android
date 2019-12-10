package com.dinterfaces.sleepapprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider: ViewModelProvider = ViewModelProviders.of(this)
        val posturaViewModel = provider.get(PosturaViewModel::class.java)

        val posturaRecyclerView = findViewById<RecyclerView>(R.id.sleepAppRecyclerView)

        posturaRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            //layoutManager = GridLayoutManager(this@MainActivity,4, GridLayoutManager.HORIZONTAL,false)
            adapter = PosturaAdapter(posturaViewModel.posturas, object : PosturaAdapter.OnItemClickListener {
                override fun onClicked(postura: Postura) {
                    Snackbar.make(
                        this@apply, // Parent view
                        "Has pulsado -> " + postura.name, // Message to show
                        Snackbar.LENGTH_SHORT // How long to display the message.
                    ).show()
                }

            })
        }

    }
}
