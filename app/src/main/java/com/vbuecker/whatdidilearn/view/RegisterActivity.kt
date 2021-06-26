package com.vbuecker.whatdidilearn.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vbuecker.whatdidilearn.R
import com.vbuecker.whatdidilearn.database.LearnedItemDao
import com.vbuecker.whatdidilearn.databinding.ActivitySecondBinding
import com.vbuecker.whatdidilearn.entities.LearnedItem
import com.vbuecker.whatdidilearn.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    private val viewModel: RegisterViewModel by viewModel()
    private var learnedItems = listOf<LearnedItem>()
    private lateinit var adapter : LearnedItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var learnedItem: LiveData<List<LearnedItem>>
        var dao: LearnedItemDao

        supportActionBar?.title = "What did I Learned"
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)


        val recycler = binding.recyclerViewRegister
        val adapter = LearnedItemAdapter()
        recycler.adapter = adapter

        val items = viewModel.learnedItem

        items.observe(this, Observer {
            adapter.learnedItems = it
        })

        binding.buttonSave.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}