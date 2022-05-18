package site.madcat.materialapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.preference.PreferenceManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import site.madcat.materialapp.databinding.ActivityMainBinding
import site.madcat.materialapp.ui.OtherFragment
import site.madcat.materialapp.ui.PictureOfTheDayFragment


class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationItemView: BottomNavigationView
    lateinit var binding: ActivityMainBinding
    private val fragmentManager: FragmentManager=supportFragmentManager
    var sp: SharedPreferences?=null
    private var savedTheme: Int=-1
    private var oldTheme: Int=-1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkProperties()
        oldTheme=savedTheme
        setTheme(savedTheme!!)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        if (savedInstanceState == null) {
            loadFragment(PictureOfTheDayFragment())
        }

        initNavigation()
    }

    fun checkProperties() {
        sp=PreferenceManager.getDefaultSharedPreferences(this);
        if (sp!!.getBoolean("themes", false) == true) {
            savedTheme=R.style.Theme_MaterialApp2
        } else {
            savedTheme=R.style.Theme_MaterialApp
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onResume() {
        checkProperties()
        if (savedTheme != oldTheme) {
            recreate()
        }
        super.onResume()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                oldTheme=savedTheme
                val intent=Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun initNavigation() {
        bottomNavigationItemView=binding.navView
        bottomNavigationItemView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_picture_of_the_day -> {
                    loadFragment(PictureOfTheDayFragment())
                }
                R.id.navigation_other_fragment -> {
                    loadFragment(
                        OtherFragment()
                    )
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