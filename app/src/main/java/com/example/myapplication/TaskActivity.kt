package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TaskActivity : AppCompatActivity() {

    lateinit var name: String
    lateinit var description: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        description = intent.getStringExtra(DESCRIPTION_EXTRA).toString()
        name = intent.getStringExtra(NAME_EXTRA).toString()
        findViewById<TextView>(R.id.name).text = name
        findViewById<TextView>(R.id.description).text = description
    }

    companion object {
        private const val NAME_EXTRA = "NAME"
        private const val DESCRIPTION_EXTRA = "DESK"

        fun getIntent(context: Context,  name: String, description: String) : Intent{
            val intent = Intent(context, TaskActivity::class.java)
            intent.putExtra(NAME_EXTRA, name)
            intent.putExtra(DESCRIPTION_EXTRA, description)
            return intent
        }
    }
}