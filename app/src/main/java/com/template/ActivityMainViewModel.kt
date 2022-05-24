package com.template

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.json.JSONObject
import org.json.JSONTokener

class ActivityMainViewModel(
    private val application: Application
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun jsonRead() {

        val jsonFile = application.applicationContext.assets
            .open("text_content.json")
            .bufferedReader().use {
                it.readText()
            }

        val jsonObject = JSONTokener(jsonFile).nextValue() as JSONObject
        val jsonArray = jsonObject.getJSONArray("sections")

        for (i in 0 until jsonArray.length()) {
            val sectionName = jsonArray.getJSONObject(i).getString("sectionName")
            val sectionArticles = jsonArray.getJSONObject(i).getJSONArray("articles")

            for (y in 0 until sectionArticles.length()) {
                val articleId = sectionArticles.getJSONObject(y).getString("id")
                val articleName = sectionArticles.getJSONObject(y).getString("articleName")
                val articleBody = sectionArticles.getJSONObject(y).getString("articleBody")

                val articlesModel = ArticlesItemsModel(articleId.toInt(), articleName, articleBody)
                val sectionsModel = SectionsModel(sectionName, articlesModel)

                Log.d("rrr = ", "articlesModel= $articlesModel")
                Log.d("qqq = ", "sectionsModel= $sectionsModel")
            }
        }
    }
}