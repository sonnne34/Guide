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

        val position = args.poition - 1
        val str = listOf(
            getString(R.string.articles_text_1),
            getString(R.string.articles_text_2),
            getString(R.string.articles_text_3),
            getString(R.string.articles_text_4),
            getString(R.string.articles_text_5),
            getString(R.string.articles_text_6),
            getString(R.string.articles_text_7),
            getString(R.string.articles_text_8),
            getString(R.string.articles_text_9),
            getString(R.string.articles_text_10),
            getString(R.string.articles_text_11),
            getString(R.string.articles_text_12),
            getString(R.string.articles_text_13),
            getString(R.string.articles_text_14),
            getString(R.string.articles_text_15),
        )
        binding.txtArticles.text = str[position]
        binding.btnHome.setOnClickListener {
            findNavController().navigate(ItemsFragmentDirections.actionNavArticleItemToNavSections())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}