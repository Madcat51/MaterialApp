package site.madcat.materialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

import site.madcat.materialapp.databinding.ActivityMainBinding
import site.madcat.materialapp.ui.OtherFragment
import site.madcat.materialapp.ui.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationItemView: BottomNavigationView
    lateinit var binding: ActivityMainBinding
    private val fragmentManager: FragmentManager=supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            loadFragment(PictureOfTheDayFragment())
        }
        initNavigation()

    }

    fun initNavigation() {
        bottomNavigationItemView=binding.navView
        bottomNavigationItemView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_picture_of_the_day -> {
                    loadFragment(PictureOfTheDayFragment())
                }
                R.id.navigation_other_fragment-> {
                    loadFragment(OtherFragment())
                }

            }; true
        }
    }

    fun loadFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .commit()
    }


}