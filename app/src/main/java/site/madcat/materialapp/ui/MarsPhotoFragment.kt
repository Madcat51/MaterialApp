package site.madcat.materialapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import coil.load
import site.madcat.materialapp.R

import site.madcat.materialapp.databinding.FragmentMarsPhotoBinding
import site.madcat.materialapp.domain.NasaRepoImpl

class MarsPhotoFragment : Fragment() {
    private val MarsPhotoViewModel: MarsPhotoViewModel by viewModels {
        MarsPhotoViewModelFactory(NasaRepoImpl())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {

            MarsPhotoViewModel.requestPhotoOfTheMars()
        }
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
            MarsPhotoViewModel.error.collect {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }

        viewLifecycleOwner.lifecycle.coroutineScope.launchWhenStarted {
            MarsPhotoViewModel.requestResult.collect { photos ->
                photos?.let {
                    binding.titlePhotoMarsEditText.setText(it)
                   // binding.photoMarsImageview.load(it)
                }
            }
        }

    }


}