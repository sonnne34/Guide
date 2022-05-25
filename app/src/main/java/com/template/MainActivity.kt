package com.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.template.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_sections, R.id.nav_articles, R.id.nav_article_item
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navigationItemSelectedListener(navView)
    }

    private fun navigationItemSelectedListener(navView: NavigationView) {
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_section_one -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    val args = Bundle()
                    args.putInt("position", 1)
                    navController.navigate(R.id.nav_articles, args)
                    true
                }
                R.id.nav_section_two -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
//                    navController.navigate(SectionsFragmentDirections.actionNavSectionsToNavArticles(2))
                    val args = Bundle()
                    args.putInt("position", 2)
                    navController.navigate(R.id.nav_articles, args)
                    true
                }
                R.id.nav_section_three -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    val args = Bundle()
                    args.putInt("position", 3)
                    navController.navigate(R.id.nav_articles, args)
//                    navController.navigate(SectionsFragmentDirections.actionNavSectionsToNavArticles(3))
                    true
                }
                else -> true
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}