package site.madcat.materialapp.ui


import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import coil.load
import site.madcat.materialapp.R
import site.madcat.materialapp.databinding.FragmentPictureOfTheDayBinding
import site.madcat.materialapp.domain.NasaRepoImpl
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class PictureOfTheDayFragment : Fragment(R.layout.fragment_picture_of_the_day) {
    private val viewModel: PictureOfTheDayViewModel by viewModels {
        MainViewModelFactory(NasaRepoImpl())
    }


    @RequiresApi(Build.VERSION_CODES.O)
    val currentdate=LocalDateTime.now()

    @RequiresApi(Build.VERSION_CODES.O)
    val formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd")

    lateinit var today: String
    lateinit var yesterday: String
    lateinit var beforeyesterday: String

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        today=currentdate.format(formatter).toString()
        yesterday=LocalDate.now().minusDays(1).toString();
        beforeyesterday=LocalDate.now().minusDays(2).toString();

        if (savedInstanceState == null) {
            viewModel.requestPictureOfTheDay(today)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentPictureOfTheDayBinding.bind(view)

        binding.searchWikkiButton.setOnClickListener {
            val intent: Intent
            intent=Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://ru.wikipedia.org/w/index.php?search=" + binding.inputWikiTextEditText.text)
            )
            startActivity(intent)
        }

        binding.beforeYesterdayChip.setOnClickListener {
            viewModel.requestPictureOfTheDay(beforeyesterday)
        }
        binding.yesterdayChip.setOnClickListener {
            viewModel.requestPictureOfTheDay(yesterday)
        }
        binding.todayChip.setOnClickListener {
            viewModel.requestPictureOfTheDay(today)
        }


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
                titlePicture.let {
                    binding.titleTextPictureEditText.setText(it)
                }
            }
        }
        viewLifecycleOwner.lifecycle.coroutineScope.launchWhenStarted {
            viewModel.explanation.collect { explanation ->
                explanation.let {
                    binding.explanationTextPictureEditText.setText(it)
                }
            }
        }
    }
}




