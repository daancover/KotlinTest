package com.coverlabs.kotlintest.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.coverlabs.kotlintest.R
import com.coverlabs.kotlintest.SettingsActivity
import com.coverlabs.kotlintest.ui.fragment.ItemListFragment
import com.coverlabs.kotlintest.ui.fragment.dummy.DummyContent
import com.coverlabs.kotlintest.ui.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemListFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem) {
        Toast.makeText(this, item.details, Toast.LENGTH_SHORT).show()
    }

    private var mPresenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = MainPresenter()

        tv_message.text = getString(R.string.label_test_text)
        bv_navigation.setOnNavigationItemSelectedListener(mPresenter?.getItemSelectedListener(supportFragmentManager))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_settings -> {
                val intent = SettingsActivity.newIntent(this)
                startActivity(intent)
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }
}
