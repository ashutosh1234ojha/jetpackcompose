package com.ashutosh1234ojha.mvvm.presentation.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ashutosh Ojha on 17,March,2022
 */

@AndroidEntryPoint
class RecipesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return ComposeView(requireContext()).apply {
            setContent {
                Text(text = "RecipesFragment")
            }
        }
    }


}