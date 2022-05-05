package site.madcat.materialapp.ui


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import coil.load
import site.madcat.materialapp.R
import site.madcat.materialapp.databinding.FragmentFirstBinding
import site.madcat.materialapp.domain.NasaRepoImpl


class PictureOfTheDayFragment : Fragment(R.layout.fragment_first) {

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(NasaRepoImpl())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.requestPictureOfTheDay()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFirstBinding.bind(view)

        viewLifecycleOwner.lifecycle.coroutineScope.launchWhenStarted {
            viewModel.error.collect {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }

        viewLifecycleOwner.lifecycle.coroutineScope.launchWhenStarted {
            viewModel.image.collect { url ->
                url?.let {
                    binding.pictureOfDayImageview.load(it)
                }

            }
        }
        viewLifecycleOwner.lifecycle.coroutineScope.launchWhenStarted {
            viewModel.title.collect { titlePicture ->
                titlePicture?.let {
                    binding.textTextView.text=(it)
                }

            }
        }
    }
}


