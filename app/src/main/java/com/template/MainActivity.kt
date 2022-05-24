package com.template

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.template.databinding.ActivityMainBinding
import org.json.JSONObject
import org.json.JSONTokener

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        jsonRead()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_sections, R.id.nav_articles, R.id.nav_item_article
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navigationItemSelectedListener(navView)
    }

    private fun navigationItemSelectedListener(navView: NavigationView) {
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_one -> {
                    drawerLayout.closeDrawer(GravityCompat.START)

                    true
                }
                R.id.nav_two -> {
                    drawerLayout.closeDrawer(GravityCompat.START)

                    true
                }
                R.id.nav_three -> {
                    drawerLayout.closeDrawer(GravityCompat.START)

                    true
                }
                R.id.nav_four -> {
                    drawerLayout.closeDrawer(GravityCompat.START)

                    true
                }
                R.id.nav_five -> {
                    drawerLayout.closeDrawer(GravityCompat.START)

                    true
                }
                else -> true
            }
        }
    }

    fun jsonRead() {

        val jsonFile = application.applicationContext.assets
            .open("text_content.json")
            .bufferedReader().use {
                it.readText()
            }
        val list: ArrayList<Model> = ArrayList()
        val sectionsList: ArrayList<SectionsModel> = ArrayList()
        val itemList: ArrayList<ArticlesItemsModel> = ArrayList()

        val jsonObject = JSONTokener(jsonFile).nextValue() as JSONObject
        val jsonArray = jsonObject.getJSONArray("sections")

        list.add(Model(jsonArray.)

        Log.d("rrr = ", "list= $list")

        for(sectionModel in list) {
            val model = SectionsModel()
            model.sectionName = sectionModel.sectionName
            sectionsList.add(model)
            ArticlesObj.addSection(model)

            Log.d("rrr = ", "ArticlesObj= $ArticlesObj")
            for (i in sectionModel.articles) {
                sectionsList.add(SectionsModel(i.value))

            }
        }


        Log.d("rrr = ", "sectionsList= $sectionsList")

//        for (i in 0 until jsonArray.length()) {
//            val sectionName = jsonArray.getJSONObject(i).getString("sectionName")
//            val sectionArticles = jsonArray.getJSONObject(i).getJSONArray("articles")
//
//            for (y in 0 until sectionArticles.length()) {
//                val articleId = sectionArticles.getJSONObject(y).getString("id")
//                val articleName = sectionArticles.getJSONObject(y).getString("articleName")
//                val articleBody = sectionArticles.getJSONObject(y).getString("articleBody")
//
//                val articlesModel = ArticlesItemsModel(articleId.toInt(), articleName, articleBody)
//                val model = Model(sectionName, articlesModel)
//
//                Log.d("rrr = ", "articlesModel= $articlesModel")
//                Log.d("qqq = ", "sectionsModel= $model")
//            }
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}