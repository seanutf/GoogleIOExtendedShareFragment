package com.seabutf.android.share.googleioextendedfragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.strictmode.FragmentStrictMode
import androidx.fragment.app.strictmode.SetRetainInstanceUsageViolation
import androidx.fragment.app.strictmode.SetUserVisibleHintViolation


fun Fragment.strictMode(){
    FragmentStrictMode.defaultPolicy = FragmentStrictMode.Policy.Builder()
        .detectRetainInstanceUsage()
        .detectSetUserVisibleHint()
        .detectTargetFragmentUsage()
        .detectWrongFragmentContainer()
        .detectFragmentReuse()
        .allowViolation(this.javaClass, SetRetainInstanceUsageViolation::class.java)
        //.allowViolation(this.javaClass, SetUserVisibleHintViolation::class.java)
        .apply {
            if(BuildConfig.DEBUG) {
                penaltyDeath()
            } else {
                penaltyListener{
                    //custom
                }
            }
        }
        .build()
}