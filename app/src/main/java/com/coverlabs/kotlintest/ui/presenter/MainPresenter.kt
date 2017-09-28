package com.coverlabs.kotlintest.ui.presenter

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import com.coverlabs.kotlintest.R
import com.coverlabs.kotlintest.ui.fragment.FavoritesFragment
import com.coverlabs.kotlintest.ui.fragment.ItemListFragment
import com.coverlabs.kotlintest.ui.fragment.SearchFragment
import com.coverlabs.kotlintest.util.ActivityUtils

/**
 * Created by Daniel on 28/09/2017.
 */

class MainPresenter {
    fun getItemSelectedListener(fragmentManager: FragmentManager): BottomNavigationView.OnNavigationItemSelectedListener? {
        return BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    ActivityUtils.replaceFragment(fragmentManager, ItemListFragment.newInstance(1), R.id.container_main)
                    true
                }

                R.id.menu_search -> {
                    ActivityUtils.replaceFragment(fragmentManager, SearchFragment.newInstance(), R.id.container_main)
                    true
                }

                R.id.menu_favorites -> {
                    ActivityUtils.replaceFragment(fragmentManager, FavoritesFragment.newInstance(), R.id.container_main)
                    true
                }

                else -> false
            }
        }
    }
}