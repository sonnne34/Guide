package com.template

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.template.databinding.FragmentSectionsBinding
import org.json.JSONObject
import org.json.JSONTokener

class SectionsFragment : Fragment() {

    private var _binding: FragmentSectionsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSectionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val activityMainViewModel =
//            ViewModelProvider(this)[ActivityMainViewModel::class.java]

//        val textView: TextView = binding.itemCardSectionOne.txtItemCard
//        activityMainViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
//        activityMainViewModel.jsonRead()

//        jsonRead()

        val sectionsList: ArrayList<SectionsModel> = ArticlesObj.sectionsModel

        val model: SectionsModel = sectionsList[0]
        sectionsList.add(model)


//        binding.itemCardSectionOne.txtItemCard.text = SectionsModel().sectionName
        binding.itemCardSectionOne.txtItemCard.text = model.sectionName


    }

    private fun jsonRead() {

        val jsonFile = requireActivity().applicationContext.assets
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}