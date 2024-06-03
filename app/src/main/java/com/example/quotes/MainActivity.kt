package com.example.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quotes.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rvQuotes.layoutManager = LinearLayoutManager(this)

        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitInstance.apiQuote.getQuotes()
            val photos = RetrofitInstance.apiPhoto.getPhotos("b9hYF1ggohxel9KSS1DSaHNgySbBGDYC_gt6Mg1oS5g", 1, 10)
            withContext(Dispatchers.Main) {
                binding.rvQuotes.adapter = QuotesAdapter(response, photos)
            }
        }
    }
}