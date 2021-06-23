package com.vbuecker.whatdidilearn.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.vbuecker.whatdidilearn.WhatDidIlearnedApplication
import com.vbuecker.whatdidilearn.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "What did I Learned"

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        val recycler = binding.recyclerView
        val adapter = LearnedItemAdapter()
        recycler.adapter = adapter

        val repository = (application as WhatDidIlearnedApplication).repository
        val items = repository.learnedItem

        items.observe(this, Observer{
            adapter.learnedItems = it })

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

}

