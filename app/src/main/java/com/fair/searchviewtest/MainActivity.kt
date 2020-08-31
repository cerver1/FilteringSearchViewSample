package com.fair.searchviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.fair.searchviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerAdapter

    private var _binding : ActivityMainBinding? = null
    private val viewBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        viewBinding.apply {

            val list = arrayListOf("1", "2", "3", "4", "5")

            adapter = RecyclerAdapter(list)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter

            searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    adapter.filter.filter(newText)
                    return false
                }

            })

        }
    }

}