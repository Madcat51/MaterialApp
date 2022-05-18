package site.madcat.materialapp.ui
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

import site.madcat.materialapp.domain.NasaRepo
import java.io.IOException


class MarsPhotoViewModel(private val repository: NasaRepo) : ViewModel() {
    private val _requestResult:MutableSharedFlow<String> =MutableSharedFlow()
    val requestResult: Flow<String> = _requestResult


    private val _image: MutableStateFlow<String?> =MutableStateFlow(null)
    val image: Flow<String?> =_image

    private val _error: MutableSharedFlow<String> =MutableSharedFlow()
    val error: Flow<String> =_error


    fun requestPhotoOfTheMars() {
        viewModelScope.launch {




        }

    }
}

class MarsPhotoViewModelFactory(private val repository: NasaRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T=MarsPhotoViewModel( repository) as T

}



