package com.ashutosh1234ojha.Interoperability

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment

/**
 * Created by Ashutosh Ojha on 17,March,2022
 */
class XmlInComposeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                //Text(text = "RecipeFragment")
                BasicList()
            }
        }
    }

    @Composable
    fun BasicList() {

        Column(modifier = Modifier.fillMaxSize()) {

            AndroidView(factory = {
                TextView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                    )
                    text = "Hello Android View"
                }
            })

        }


    }

}