package com.varun.loginappkotlin.ui.main.homepage

import android.os.Bundle
import android.util.Log
import android.view.View

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.varun.loginappkotlin.data.remote.response.DataList
import com.varun.loginappkotlin.databinding.ActivityHomeBinding
import com.varun.loginappkotlin.ui.main.DataAdapter
import com.varun.loginappkotlin.utils.common.Toaster
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 *  Author : @Varun Kumar
 *
 * */
@AndroidEntryPoint
class RecyclerViewHomeActivity : AppCompatActivity() {
    private lateinit var dataAdapter: DataAdapter
    private lateinit var dashboardManager: RecyclerView.LayoutManager
    private var dataList: ArrayList<DataList?> = ArrayList<DataList?>()
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
//    private var progressbar : LottieAnimationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        progressbar = findViewById<LottieAnimationView>(R.id.progressBar)

        initializeRecyclerView()
        initializeObservers()
    }


    private fun initializeRecyclerView() {
        dataAdapter = DataAdapter(this, dataList)

        binding.recyclerView.apply {
            dashboardManager = LinearLayoutManager(context)
            layoutManager = dashboardManager
            adapter = dataAdapter
        }
        viewModel.getCurrentMatches()
    }

    private fun initializeObservers() {
        viewModel.loading.observe(this, Observer {

            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
            if (it) binding.progressBar.playAnimation()
            else binding.progressBar.cancelAnimation()
        })

        viewModel.getloginResponse.observe(this, Observer {
            dataList = (it.data?.list as ArrayList<DataList?>)

            it.data.run {
                if (dataList.isNotEmpty()) {
                    dataAdapter.onAddItems(dataList)
                    binding.recyclerView.visibility = View.VISIBLE
                } else {
                    binding.recyclerView.visibility = View.GONE

                }
            }
        })

    }

}