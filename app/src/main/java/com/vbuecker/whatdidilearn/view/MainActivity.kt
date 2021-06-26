package com.vbuecker.whatdidilearn.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.vbuecker.whatdidilearn.databinding.ActivityMainBinding
import com.vbuecker.whatdidilearn.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val recycler = binding.recyclerView
        val adapter = LearnedItemAdapter()
        recycler.adapter = adapter

        val items = viewModel.learnedItem

        items.observe(this, Observer {
            adapter.learnedItems = it
        })

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

}

