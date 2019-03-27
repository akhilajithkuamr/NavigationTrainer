package com.example.allfootball

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.example.allfootball.commons.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private val homeFragment: HomeFragment =
        HomeFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)

        val toolbar: android.support.v7.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)

/*
        val fragment=supportFragmentManager
        fragment.beginTransaction().add(R.id.myFrame,homeFragment).commit()*/


        val actionBar: ActionBar? = supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_list_24px)

        }
        val navigationView: NavigationView = findViewById(R.id.nav_view)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            var fragment: Fragment? = null
            val fragmentClass: Class<*>
            when (menuItem.itemId) {
                R.id.nav_account -> {
                    fragmentClass = MyAccountFragment::class.java
                    myLinearLayout.visibility = View.GONE

                }
                R.id.nav_gallery -> {
                    fragmentClass = GalleryFragment::class.java
                    myLinearLayout.visibility = View.GONE

                }
                R.id.nav_slideshow -> {
                    fragmentClass = SlideShowFragment::class.java
                    myLinearLayout.visibility = View.GONE

                }
                R.id.nav_manage -> {
                    fragmentClass = ToolsFragment::class.java
                    myLinearLayout.visibility = View.GONE

                }
                R.id.nav_home -> {
                    fragmentClass = HomeFragment::class.java
                    myLinearLayout.visibility = View.VISIBLE
                }

                else -> {
                    fragmentClass = GalleryFragment::class.java
                    myLinearLayout.visibility = View.GONE

                }
            }
            try {
                fragment = fragmentClass.newInstance() as Fragment
            } catch (e: Exception) {
                e.printStackTrace()
            }

            val fragmentManager = supportFragmentManager
            if (fragment != null) {
                fragmentManager.beginTransaction().replace(R.id.myFrame, fragment)
                    .addToBackStack(null)
                    .commit()
            }
            true


        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}