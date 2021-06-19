package com.vbuecker.whatdidilearn

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vbuecker.whatdidilearn.data.LearnedItemDataBase
import com.vbuecker.whatdidilearn.databinding.ActivityMainBinding
import com.vbuecker.whatdidilearn.view.LearnedItemAdapter


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.recyclerView
        val adapter = LearnedItemAdapter()
        adapter.learnedItems = LearnedItemDataBase().getAll()
        recycler.adapter = adapter
    }

}

