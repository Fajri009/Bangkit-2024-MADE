package com.example.bangkit_2024_made.ReactiveProgramming.CoroutineFlow

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.bangkit_2024_made.R
import kotlinx.coroutines.launch

class MainActivityReactiveSearch : AppCompatActivity() {
    val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_reactive_search)

        val edPlace = findViewById<AutoCompleteTextView>(R.id.ed_place)

        edPlace.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                lifecycleScope.launch {
                    viewModel.queryChannel.value = s.toString()
                }
            }
        })

        viewModel.searchResult.observe(this, Observer { placesItem ->
            val placesName = placesItem.map { it.placeName }
            val adapter = ArrayAdapter(this@MainActivityReactiveSearch, android.R.layout.select_dialog_item, placesName)
            adapter.notifyDataSetChanged()
            edPlace.setAdapter(adapter)
        })
    }
}