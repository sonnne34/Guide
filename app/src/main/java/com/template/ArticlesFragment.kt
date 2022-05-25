package com.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.template.databinding.FragmentArticlesBinding

class ArticlesFragment : Fragment() {

    private var _binding: FragmentArticlesBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<ArticlesFragmentArgs>()

    private lateinit var articleOne: TextView
    private lateinit var articleTwo: TextView
    private lateinit var articleThree: TextView

    private lateinit var imgArticleOne: ImageView
    private lateinit var imgArticleTwo: ImageView
    private lateinit var imgArticleThree: ImageView

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

        when (args.position) {
            1 -> {
                imgArticleOne.setBackgroundResource(R.drawable.img_article_1_1)
                imgArticleTwo.setBackgroundResource(R.drawable.img_article_1_2)
                imgArticleThree.setBackgroundResource(R.drawable.img_article_1_3)

                articleOne.text = getString(R.string.articles_name_1_1)
                articleTwo.text = getString(R.string.articles_name_1_2)
                articleThree.text = getString(R.string.articles_name_1_3)

                onClickListener(imgArticleOne, 1)
                onClickListener(imgArticleTwo, 2)
                onClickListener(imgArticleThree, 3)
            }
            2 -> {
                imgArticleOne.setBackgroundResource(R.drawable.img_article_2_1)
                imgArticleTwo.setBackgroundResource(R.drawable.img_article_2_2)
                imgArticleThree.setBackgroundResource(R.drawable.img_article_2_3)

                articleOne.text = getString(R.string.articles_name_2_1)
                articleTwo.text = getString(R.string.articles_name_2_2)
                articleThree.text = getString(R.string.articles_name_2_3)

                onClickListener(imgArticleOne, 4)
                onClickListener(imgArticleTwo, 5)
                onClickListener(imgArticleThree, 6)
            }
            3 -> {
                imgArticleOne.setBackgroundResource(R.drawable.img_article_3_1)
                imgArticleTwo.setBackgroundResource(R.drawable.img_article_3_2)
                imgArticleThree.setBackgroundResource(R.drawable.img_article_3_3)

                articleOne.text = getString(R.string.articles_name_3_1)
                articleTwo.text = getString(R.string.articles_name_3_2)
                articleThree.text = getString(R.string.articles_name_3_3)

                onClickListener(imgArticleOne, 7)
                onClickListener(imgArticleTwo, 8)
                onClickListener(imgArticleThree, 9)
            }

            4 -> {
                imgArticleOne.setBackgroundResource(R.drawable.img_article_4_1)
                imgArticleTwo.setBackgroundResource(R.drawable.img_article_4_2)
                imgArticleThree.setBackgroundResource(R.drawable.img_article_4_3)

                articleOne.text = getString(R.string.articles_name_4_1)
                articleTwo.text = getString(R.string.articles_name_4_2)
                articleThree.text = getString(R.string.articles_name_4_3)

                onClickListener(imgArticleOne, 10)
                onClickListener(imgArticleTwo, 11)
                onClickListener(imgArticleThree, 12)
            }

            5 -> {
                imgArticleOne.setBackgroundResource(R.drawable.img_article_5_1)
                imgArticleTwo.setBackgroundResource(R.drawable.img_article_5_2)
                imgArticleThree.setBackgroundResource(R.drawable.img_article_5_3)

                articleOne.text = getString(R.string.articles_name_5_1)
                articleTwo.text = getString(R.string.articles_name_5_2)
                articleThree.text = getString(R.string.articles_name_5_3)

                onClickListener(imgArticleOne, 13)
                onClickListener(imgArticleTwo, 14)
                onClickListener(imgArticleThree, 15)
            }

            else -> {
                throw RuntimeException("Error: Section is not found")
            }
        }
    }

    private fun onClickListener(img: ImageView, position: Int) {
        img.setOnClickListener {
            findNavController().navigate(
                ArticlesFragmentDirections.actionNavArticlesToNavArticleItem(
                    position
                )
            )
        }
    }

    private fun bindingView() {
        with(binding) {
            articleOne = itemCardArticleOne.txtItemCard
            articleTwo = itemCardArticleTwo.txtItemCard
            articleThree = itemCardArticleThree.txtItemCard

            imgArticleOne = itemCardArticleOne.imgItemCard
            imgArticleTwo = itemCardArticleTwo.imgItemCard
            imgArticleThree = itemCardArticleThree.imgItemCard

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}