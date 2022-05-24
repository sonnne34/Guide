package com.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.template.databinding.FragmentSectionsBinding

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

        with(binding) {
            itemCardSectionOne.txtItemCard.text = getString(R.string.section_name_one)
            itemCardSectionOne.txtItemCard.setOnClickListener {
                findNavController().navigate(R.id.action_nav_sections_to_nav_articles)
            }
            itemCardSectionTwo.txtItemCard.text = getString(R.string.section_name_two)
            itemCardSectionTwo.txtItemCard.setOnClickListener {
                findNavController().navigate(R.id.action_nav_sections_to_nav_articles)
            }
            itemCardSectionThree.txtItemCard.text = getString(R.string.section_name_three)
            itemCardSectionThree.txtItemCard.setOnClickListener {
                findNavController().navigate(R.id.action_nav_sections_to_nav_articles)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}