package com.vbuecker.whatdidilearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.vbuecker.whatdidilearn.databinding.ActivityMainBinding
import com.vbuecker.whatdidilearn.view.LearnedItemAdapter


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

        val database = (application as WhatDidIlearnedApplication).database
        val items = database.learnedItemDao().getAll()

        items.observe(this, Observer{
            adapter.learnedItems = it })

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

}

