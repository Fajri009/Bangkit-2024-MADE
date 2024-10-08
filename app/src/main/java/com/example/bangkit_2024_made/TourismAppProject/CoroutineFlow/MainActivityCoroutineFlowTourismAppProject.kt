package com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.bangkit_2024_made.R
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.favorite.FavoriteFragment
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.home.HomeFragment
import com.example.bangkit_2024_made.databinding.ActivityMainCoroutineFlowTourismAppBinding
import com.google.android.material.navigation.NavigationView

class MainActivityCoroutineFlowTourismAppProject : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainCoroutineFlowTourismAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCoroutineFlowTourismAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, HomeFragment())
                .commit()
            supportActionBar?.title = getString(R.string.app_name)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        var title = getString(R.string.app_name)
        when (item.itemId) {
            R.id.nav_home -> {
                fragment = HomeFragment()
                title = getString(R.string.app_name)
            }
            R.id.nav_favorite -> {
                fragment = FavoriteFragment()
                title = getString(R.string.menu_favorite)
            }
            R.id.nav_map -> {
                Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show()
            }
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }
        supportActionBar?.title = title

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}