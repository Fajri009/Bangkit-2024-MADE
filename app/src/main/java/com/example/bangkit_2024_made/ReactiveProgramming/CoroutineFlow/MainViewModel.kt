package com.example.bangkit_2024_made.ReactiveProgramming.CoroutineFlow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.bangkit_2024_made.ReactiveProgramming.CoroutineFlow.network.ApiConfig
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel : ViewModel() {
    private val accessToken = "wjGe9jt0vNHv9OS71fQv"
    val queryChannel = MutableStateFlow("")

    val searchResult = queryChannel
        .debounce(300) // Memastikan agar eksekusi selanjutnya berjalan jika ada jeda 300 millisecond
        .distinctUntilChanged() // Berfungsi kala request sebelumnya dengan sekarang, sama
        .filter { // melakukan filter jika yang diketik hanya spasi atau masih kosong
            it.trim().isNotEmpty()
        }
        .mapLatest { // Berfungsi kala  melakukan transformasi flow menjadi data yang baru dengan hanya menghasilkan nilai terakhir
            ApiConfig.provideApiService().getCountry(it, accessToken).features
        }
        .asLiveData() // Mengubah Flow menjadi LiveData
}