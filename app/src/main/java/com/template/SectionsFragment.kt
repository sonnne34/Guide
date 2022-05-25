package com.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
            itemCardSectionOne.imgItemCard.setBackgroundResource(R.drawable.img_section_1)
            itemCardSectionOne.txtItemCard.text = getString(R.string.section_name_1)
            onClickListener(itemCardSectionOne.imgItemCard, 1)

            itemCardSectionTwo.imgItemCard.setBackgroundResource(R.drawable.img_section_2)
            itemCardSectionTwo.txtItemCard.text = getString(R.string.section_name_2)
            onClickListener(itemCardSectionTwo.imgItemCard, 2)

            itemCardSectionThree.imgItemCard.setBackgroundResource(R.drawable.img_section_3)
            itemCardSectionThree.txtItemCard.text = getString(R.string.section_name_3)
            onClickListener(itemCardSectionThree.imgItemCard, 3)

            itemCardSectionFour.imgItemCard.setBackgroundResource(R.drawable.img_section_4)
            itemCardSectionFour.txtItemCard.text = getString(R.string.section_name_4)
            onClickListener(itemCardSectionFour.imgItemCard, 4)

            itemCardSectionFive.imgItemCard.setBackgroundResource(R.drawable.img_section_5)
            itemCardSectionFive.txtItemCard.text = getString(R.string.section_name_5)
            onClickListener(itemCardSectionFive.imgItemCard, 5)
        }
    }

    private fun onClickListener(img: ImageView, position: Int) {
        img.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections.actionNavSectionsToNavArticles(position)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}