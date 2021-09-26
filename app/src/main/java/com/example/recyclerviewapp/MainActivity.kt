package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var clMain: ConstraintLayout
    lateinit var mv_headerText: TextView
    lateinit var mv_addText: TextInputEditText
    lateinit var mv_addButton: Button
    lateinit var myRV: RecyclerView
    lateinit var savedTexts: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mv_headerText = findViewById(R.id.mv_headerText)
        mv_addText = findViewById(R.id.mv_addText)
        mv_addButton = findViewById(R.id.mv_addButton)
        savedTexts = ArrayList()

        myRV = findViewById<RecyclerView>(R.id.rv_main)

        clMain = findViewById<ConstraintLayout>(R.id.clMain)

        mv_addButton.setOnClickListener { addTextToView() }

    }

    fun addTextToView() {
        if (mv_addText.text.toString() == "") {
            Snackbar.make(clMain, "Please insert a text..", Snackbar.LENGTH_LONG).show()
        } else {
            savedTexts.add(mv_addText.text.toString())
            myRV.adapter = RecyclerViewAdapter(savedTexts)
            myRV.layoutManager = LinearLayoutManager(this)
        }
    }
}