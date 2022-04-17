package com.ashutosh1234ojha.Interoperability

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import com.ashutosh1234ojha.jetpackcompose.R

/**
 * Created by Ashutosh Ojha on 17,March,2022
 */
class ComposeInXmlFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_compose_in_xml, container, false)

        view.findViewById<ComposeView>(R.id.composeView).setContent {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .border(border = BorderStroke(1.dp, Color.Black))
                    .padding(16.dp)
            ) {
                Text(text = "In side fragment compose")
                Spacer(modifier = Modifier.padding(18.dp))
                val customView = HorizontalDottedProgress(LocalContext.current)
                AndroidView(factory = { customView })

            }
        }
        return view
    }


}