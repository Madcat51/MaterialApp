package site.madcat.materialapp.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import coil.load
import site.madcat.materialapp.R
import site.madcat.materialapp.databinding.FragmentMarsPhotoBinding
import site.madcat.materialapp.domain.NasaRepoImpl
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MarsPhotoFragment : Fragment() {

    private val MarsPhotoViewModel: MarsPhotoViewModel by viewModels {
        MarsPhotoViewModelFactory(NasaRepoImpl())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            MarsPhotoViewModel.requestPhotoOfTheMars(getDate())
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDate(): String {
        val formatDate=DateTimeFormatter.ofPattern("yyyy-M-dd")

        val datePhoto=LocalDateTime.now().minusDays((0..365).random().toLong()).format(formatDate)
        return datePhoto.toString()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mars_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentMarsPhotoBinding.bind(view)



        viewLifecycleOwner.lifecycle.coroutineScope.launchWhenStarted {
            MarsPhotoViewModel.message.collect {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }

        viewLifecycleOwner.lifecycle.coroutineScope.launchWhenStarted {
            MarsPhotoViewModel.image.collect { image ->
                image?.let {

                    val index=(0..image?.photos?.count()).random()
                    binding.photoMarsImageview.load(image?.photos?.get(index)?.image)
                    binding.titlePhotoMarsEditText.setText(image?.photos?.get(index)?.date.toString())
                }
            }
        }

    }


}