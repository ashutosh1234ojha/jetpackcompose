package com.ashutosh1234ojha.paging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ashutosh1234ojha.jetpackcompose.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Ashutosh Ojha on 05,January,2022
 * https://www.youtube.com/watch?v=MZBBOAa5auY&ab_channel=NamasteCoder
 *
 */
class PagingActivity : AppCompatActivity() {
    lateinit var viewModel: PhotoViewModel
    lateinit var  adapterPhoto : PhotoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging)

        viewModel = ViewModelProvider(
            this,
            PhotoViewModelFactory(ApiInterface.getApi())
        )[PhotoViewModel::class.java]

        adapterPhoto = PhotoAdapter()
//        bindUtil()

        lifecycleScope.launch {

            viewModel.pageList.collect {
                adapterPhoto.submitData(it)
            }
        }

        bindUtil()


    }

    fun   bindUtil(){
        val rv = findViewById<RecyclerView>(R.id.rv)

        rv.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapterPhoto
        }

//        adapterPhoto.notifyDataSetChanged()
    }
}