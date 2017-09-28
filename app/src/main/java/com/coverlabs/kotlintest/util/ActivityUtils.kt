package com.coverlabs.kotlintest.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Created by Daniel on 28/09/2017.
 */
class ActivityUtils {
    companion object {
        fun replaceFragment(fragmentManager: FragmentManager, fragment: Fragment, frameId: Int) {
            val transaction: FragmentTransaction? = fragmentManager.beginTransaction()
            transaction?.replace(frameId, fragment)
            transaction?.commit()
        }
    }
}