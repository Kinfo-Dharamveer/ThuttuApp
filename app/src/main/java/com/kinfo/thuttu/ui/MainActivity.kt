package com.kinfo.thuttu.ui

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.Menu
import android.view.MenuItem
import com.kinfo.thuttu.R
import kotlinx.android.synthetic.main.activity_main.*
import com.kinfo.thuttu.adapters.ViewPagerAdapter
import android.support.v4.view.ViewPager
import android.support.design.widget.TabLayout
import com.kinfo.thuttu.BaseActivity
import android.content.Intent
import android.widget.ImageView
import android.view.View
import com.kinfo.thuttu.rxbus.RxBus


class MainActivity : BaseActivity() {

    var searchToolbar: ImageView? = null
    var refreshToolbar: ImageView? = null
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    var imgopenDrawer: ImageView? = null
    var viewPagerAdapter: ViewPagerAdapter? = null
    private var bus: RxBus? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getLayoutInflater().inflate(R.layout.main_two, frameLayout)
        bus = RxBus()

        searchToolbar =  findViewById(R.id.searchToolbar)
        refreshToolbar =  findViewById(R.id.refreshToolbar)

        imgopenDrawer =  findViewById(R.id.imgopenDrawer)
        viewPager =  findViewById(R.id.viewpager)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager!!.adapter = viewPagerAdapter

        tabLayout = findViewById(R.id.tabs)
        tabLayout!!.setupWithViewPager(viewPager)

        imgopenDrawer?.setOnClickListener(View.OnClickListener {
            drawer_layout.openDrawer(GravityCompat.START)
        })

        searchToolbar?.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        })

        refreshToolbar?.setOnClickListener(View.OnClickListener {
            viewPagerAdapter?.notifyDataSetChanged()
        })
    }

    fun bus(): RxBus? {
        return bus
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.search_button ->
                return true
            R.id.refresh_button ->
                return true
            else ->
            return super.onOptionsItemSelected(item)

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        when (item.itemId) {

            R.id.nav_latestdeals -> {

                viewPager?.setCurrentItem(0)
            }
            R.id.nav_featureddeals -> {
                viewPager?.setCurrentItem(1)

            }
            R.id.nav_recentcomments -> {
                viewPager?.setCurrentItem(2)

            }
            R.id.nav_saveddeals -> {
                viewPager?.setCurrentItem(3)

            }

            R.id.nav_rechargedeals -> {
                val intent = Intent(this, RechargeActivity::class.java)
                startActivity(intent)

            }

            R.id.nav_stores -> {
                val intent = Intent(this, StoresActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_search -> {
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_settings -> {
                startActivity(Intent(this,SettingsActivity::class.java))
            }
            R.id.nav_notifications -> {
                startActivity(Intent(this,NotificationsActivity::class.java))
            }
            R.id.nav_swtichview -> {

            }
            R.id.nav_aboutus -> {
                startActivity(Intent(this,AboutUsActivity::class.java))

            }
            R.id.nav_privacypolicy -> {
                startActivity(Intent(this,PrivacyPolicyActivity::class.java))

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }




}
