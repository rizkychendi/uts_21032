// src/main/java/com/example/yourapp/DisplayActivity.kt
package com.example.yourapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var tvWatchFor: TextView
    private lateinit var tvGenre: TextView
    private lateinit var tvYear: TextView
    private lateinit var tvDuration: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        tvTitle = findViewById(R.id.tvTitle)
        tvWatchFor = findViewById(R.id.tvWatchFor)
        tvGenre = findViewById(R.id.tvGenre)
        tvYear = findViewById(R.id.tvYear)
        tvDuration = findViewById(R.id.tvDuration)

        val title = intent.getStringExtra("title")
        val watchFor = intent.getStringExtra("watchFor")
        val genres = intent.getStringExtra("genres")
        val year = intent.getStringExtra("year")
        val duration = intent.getStringExtra("duration")

        tvTitle.text = "Title: $title"
        tvWatchFor.text = "Watch For: $watchFor"
        tvGenre.text = "Genre: $genres"
        tvYear.text = "Year: $year"
        tvDuration.text = "Duration: $duration"
    }
}
