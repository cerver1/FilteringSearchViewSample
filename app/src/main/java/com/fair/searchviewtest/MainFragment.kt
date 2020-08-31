package com.fair.searchviewtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.fair.searchviewtest.databinding.ActivityMainBinding
import com.fair.searchviewtest.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var mAdapter: RecyclerAdapter

    private var _binding : FragmentMainBinding? = null
    private val viewBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)


        viewBinding.apply {

            val list = arrayListOf("1", "2", "3", "4", "5")

            mAdapter = RecyclerAdapter(list)
            recyclerViewFragment.layoutManager = LinearLayoutManager(context)
            recyclerViewFragment.adapter = mAdapter

            searchBarFragment.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    mAdapter.filter.filter(newText)
                    return false
                }

            })
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}