package com.seabutf.android.share.googleioextendedfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seabutf.android.share.googleioextendedfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.tvOpenBanner.setOnClickListener {
            openBannerUi()
        }

        binding.tvOpenSingle.setOnClickListener {
            openSingleUi()
        }
    }

    private fun openSingleUi() {
        startActivity(Intent(this, BannerListActivity::class.java))
    }

    private fun openBannerUi() {
        startActivity(Intent(this, SingleActivity::class.java))
    }
}