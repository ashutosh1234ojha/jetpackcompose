package com.ashutosh1234ojha.Interoperability

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ashutosh1234ojha.jetpackcompose.R

/**
 * Created by Ashutosh Ojha on 17,March,2022
 */
class MainTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.mainFragmentContainer, ComposeInXmlFragment()).commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, XmlInComposeFragment()).commit()

    }
}