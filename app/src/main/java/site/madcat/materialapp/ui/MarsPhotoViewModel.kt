package site.madcat.materialapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import site.madcat.materialapp.api.ReturnPackagePhoto
import site.madcat.materialapp.domain.NasaRepo
import java.io.IOException


class MarsPhotoViewModel(private val repository: NasaRepo) : ViewModel() {

    private val _image: MutableStateFlow<ReturnPackagePhoto?> =MutableStateFlow(null)
    val image: Flow<ReturnPackagePhoto?> =_image


    private val _message: MutableSharedFlow<String> =MutableSharedFlow()
    val message: Flow<String> =_message

    fun requestPhotoOfTheMars(day: String) {
        viewModelScope.launch {
            try {
                _image.emit(repository.photoMars(day))
                _message.emit("ok")
            } catch (exc: IOException) {
                _message.emit("Error")
            }
        }


    }
}


class MarsPhotoViewModelFactory(private val repository: NasaRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T=MarsPhotoViewModel(repository) as T

}



