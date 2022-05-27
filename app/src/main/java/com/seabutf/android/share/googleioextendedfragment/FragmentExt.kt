package com.seabutf.android.share.googleioextendedfragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.strictmode.FragmentStrictMode
import androidx.fragment.app.strictmode.SetRetainInstanceUsageViolation


fun Fragment.strictMode(){
    FragmentStrictMode.defaultPolicy = FragmentStrictMode.Policy.Builder()
        .detectRetainInstanceUsage()
        .detectSetUserVisibleHint()
        .detectTargetFragmentUsage()
        .allowViolation(this.javaClass, SetRetainInstanceUsageViolation::class.java)
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