package com.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.template.databinding.FragmentItemsBinding

class ItemsFragment : Fragment() {

    private var _binding: FragmentItemsBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<ItemsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = args.position - 1

        val imgListDrawables = listOf(
            R.drawable.img_article_1_1,
            R.drawable.img_article_1_2,
            R.drawable.img_article_1_3,
            R.drawable.img_article_2_1,
            R.drawable.img_article_2_2,
            R.drawable.img_article_2_3,
            R.drawable.img_article_3_1,
            R.drawable.img_article_3_2,
            R.drawable.img_article_3_3,
            R.drawable.img_article_4_1,
            R.drawable.img_article_4_2,
            R.drawable.img_article_4_3,
            R.drawable.img_article_5_1,
            R.drawable.img_article_5_2,
            R.drawable.img_article_5_3
        )

        val articleListString = listOf(
            getString(R.string.articles_text_1_1),
            getString(R.string.articles_text_1_2),
            getString(R.string.articles_text_1_3),
            getString(R.string.articles_text_2_1),
            getString(R.string.articles_text_2_2),
            getString(R.string.articles_text_2_3),
            getString(R.string.articles_text_3_1),
            getString(R.string.articles_text_3_2),
            getString(R.string.articles_text_3_3),
            getString(R.string.articles_text_4_1),
            getString(R.string.articles_text_4_2),
            getString(R.string.articles_text_4_3),
            getString(R.string.articles_text_5_1),
            getString(R.string.articles_text_5_2),
            getString(R.string.articles_text_5_3),
        )

        binding.imgArticle.setBackgroundResource(imgListDrawables[position])
        binding.txtArticles.text = articleListString[position]
        binding.btnHome.setOnClickListener {
            findNavController().navigate(ItemsFragmentDirections.actionNavArticleItemToNavSections())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}