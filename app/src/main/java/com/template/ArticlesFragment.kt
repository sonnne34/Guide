package com.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.template.databinding.FragmentArticlesBinding

class ArticlesFragment : Fragment() {

    private var _binding: FragmentArticlesBinding? = null
    private val binding get() = _binding!!

    private lateinit var articleOne: TextView
    private lateinit var articleTwo: TextView
    private lateinit var articleThree: TextView
    private lateinit var articleFour: TextView
    private lateinit var articleFive: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticlesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingView()

        val argsSection = listOf("sectionOne", "sectionTwo", "sectionThree")

        when (argsSection.random()) {
            "sectionOne" -> {
                articleOne.text = getString(R.string.articles_name_1)
                articleTwo.text = getString(R.string.articles_name_2)
                articleThree.text = getString(R.string.articles_name_3)
                articleFour.text = getString(R.string.articles_name_4)
                articleFive.text = getString(R.string.articles_name_5)

                onClickListener(articleOne, 1)
                onClickListener(articleTwo, 2)
                onClickListener(articleThree, 3)
                onClickListener(articleFour, 4)
                onClickListener(articleFive, 5)
            }
            "sectionTwo" -> {
                articleOne.text = getString(R.string.articles_name_6)
                articleTwo.text = getString(R.string.articles_name_7)
                articleThree.text = getString(R.string.articles_name_8)
                articleFour.text = getString(R.string.articles_name_9)
                articleFive.text = getString(R.string.articles_name_10)

                onClickListener(articleOne, 6)
                onClickListener(articleTwo, 7)
                onClickListener(articleThree, 8)
                onClickListener(articleFour, 9)
                onClickListener(articleFive, 10)
            }
            "sectionThree" -> {
                articleOne.text = getString(R.string.articles_name_11)
                articleTwo.text = getString(R.string.articles_name_12)
                articleThree.text = getString(R.string.articles_name_13)
                articleFour.text = getString(R.string.articles_name_14)
                articleFive.text = getString(R.string.articles_name_15)

                onClickListener(articleOne, 11)
                onClickListener(articleTwo, 12)
                onClickListener(articleThree, 13)
                onClickListener(articleFour, 14)
                onClickListener(articleFive, 15)
            }

            else -> {
                throw RuntimeException("Error: Section is not found")
            }
        }
    }

    private fun onClickListener(tv: TextView, position: Int) {
        tv.setOnClickListener {
            findNavController().navigate(R.id.action_nav_articles_to_nav_article_item)
        }
    }

    private fun bindingView() {
        with(binding) {
            articleOne = itemCardArticleOne.txtItemCard
            articleTwo = itemCardArticleTwo.txtItemCard
            articleThree = itemCardArticleThree.txtItemCard
            articleFour = itemCardArticleFour.txtItemCard
            articleFive = itemCardArticleFive.txtItemCard
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}