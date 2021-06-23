package com.vbuecker.whatdidilearn.view

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.vbuecker.whatdidilearn.R

class SecondActivity : AppCompatActivity() {

    lateinit var radioGrouping: RadioGroup
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.title = "What did I Learned"
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)

        button = findViewById(R.id.button)
        radioGrouping = findViewById(R.id.radio_group)
        button.setOnClickListener {
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}