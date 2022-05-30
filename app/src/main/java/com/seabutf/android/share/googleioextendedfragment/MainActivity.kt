package com.seabutf.android.share.googleioextendedfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.strictmode.FragmentStrictMode
import androidx.fragment.app.strictmode.SetRetainInstanceUsageViolation
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

        FragmentStrictMode.defaultPolicy = FragmentStrictMode.Policy.Builder()
            .detectRetainInstanceUsage()
            .detectSetUserVisibleHint()
            .detectTargetFragmentUsage()
            .detectWrongFragmentContainer()
            .detectFragmentReuse()
            //.allowViolation(this.javaClass, SetRetainInstanceUsageViolation::class.java)
            //.allowViolation(this.javaClass, SetUserVisibleHintViolation::class.java)
            .apply {
                if(BuildConfig.DEBUG) {
                    penaltyDeath()
                } else {
                    penaltyListener{
                        it.fragment

                        //custom
                    }
                }
            }
            .build()

        binding.tvOpenBanner.setOnClickListener {
            openBannerUi()
        }

        binding.tvOpenSingle.setOnClickListener {
            openSingleUi()
        }
    }

    private fun openSingleUi() {
        startActivity(Intent(this, SingleActivity::class.java))
    }

    private fun openBannerUi() {
        startActivity(Intent(this, BannerListActivity::class.java))
    }
}