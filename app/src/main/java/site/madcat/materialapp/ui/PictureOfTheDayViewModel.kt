package site.madcat.materialapp.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import site.madcat.materialapp.domain.NasaRepo
import java.io.IOException


class MainViewModel(private val repo: NasaRepo) : ViewModel() {
    private val _title: MutableSharedFlow<String> =MutableSharedFlow()
    val title: Flow<String> =_title

    private val _image: MutableStateFlow<String?> =MutableStateFlow(null)
    val image: Flow<String?> =_image

    private val _error: MutableSharedFlow<String> =MutableSharedFlow()
    val error: Flow<String> =_error

    fun requestPictureOfTheDay(day: String) {
        viewModelScope.launch {
            try {
                val url=repo.pictureOfTheDay(day).url
                _image.emit(url)
                val titlePicture=repo.pictureOfTheDay(day).title
                _title.emit(titlePicture)
            } catch (exc: IOException) {
                _error.emit("Error")
            }
        }
    }

}

class MainViewModelFactory(private val repo: NasaRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T=MainViewModel(repo) as T

}