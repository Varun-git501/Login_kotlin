//package com.varun.loginappkotlin.ui.details
//
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.Observer
//import com.bumptech.glide.Glide
//import com.varun.loginappkotlin.R
//import com.varun.loginappkotlin.data.remote.response.DataList
//import com.varun.loginappkotlin.databinding.ActivityDetailsBinding
//import com.varun.loginappkotlin.utils.common.Constants
//import dagger.hilt.android.AndroidEntryPoint
//
///**
// *
// *  Author : @Varun Kumar
// *
// * */
//@AndroidEntryPoint
//class ScoreCardDetailsActivity : AppCompatActivity() {
//    companion object {
//        fun newIntent(context: Context, id: String): Intent {
//            val intent = Intent(context, ScoreCardDetailsActivity::class.java)
//            intent.putExtra(Constants.id, id)
//            return intent
//        }
//    }
//
//    private lateinit var scoreCardDetails: DataList
//    private lateinit var binding: ActivityDetailsBinding
//    val viewModel: ScoreCardDetailsViewModel by viewModels()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityDetailsBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val id = intent.getStringExtra(Constants.id)
//        viewModel.getScorecardDetails(id!!)
//        initializeObservers()
//    }
//
//    private fun initializeObservers() {
//
//        viewModel.loading.observe(this, Observer {
//            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
//            if (it) binding.progressBar.playAnimation()
//            else binding.progressBar.cancelAnimation()
//        })
//        viewModel.getDataResponse.observe(this, Observer {
//            scoreCardDetails = it.data?.list!!
//
//            scoreCardDetails.run {
//
//                Glide.with(this@ScoreCardDetailsActivity)
//                    .load(scoreCardDetails.teamInfo?.get(0)?.img).placeholder(
//                        R.mipmap.ic_launcher
//                    ).into(binding.imgTeam1)
//                binding.tvTeam1Shortname.text =
//                    scoreCardDetails.teamInfo?.get(0)?.shortname
//                Glide.with(this@ScoreCardDetailsActivity)
//                    .load(scoreCardDetails.teamInfo?.get(1)?.img).placeholder(
//                        R.mipmap.ic_launcher
//                    ).into(binding.imgTeam2)
//                binding.tvTeam2Shortname.text =
//                    scoreCardDetails.teamInfo?.get(1)?.shortname
//
//            }
//        })
//
//    }
//
//
//}