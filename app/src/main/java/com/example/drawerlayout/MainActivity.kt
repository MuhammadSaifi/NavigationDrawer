package com.example.drawerlayout
//implementation 'com.google.android.material:material:1.0.0-rc01'
//    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
// add in gradle(Module.app) otherwise not worked
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var homeFragment: HomeFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val drawerToggle :ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        ) {
            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)
                setTitle(R.string.app_name)
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                setTitle(R.string.options)
            }
        }

        homeFragment= HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.content_frame,homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

       navigationView.setNavigationItemSelectedListener { item ->
           when(item?.itemId){
               R.id.home  ->{
                   loadhome(HomeFragment())
                   true
               }
               R.id.gallery-> {
                   loadgallary(GallaryFragment())
                   true
               }
               R.id.share -> {
                   loadshare(ShareFragment())
                   true
               }
               R.id.log ->{
                   loadlog(LogFragment())
                   true
               }
               else -> super.onOptionsItemSelected(item)

               }
           drawerLayout.closeDrawer(GravityCompat.START)
           true

       }

    }



    fun loadhome(frag1 : HomeFragment){
        val h = supportFragmentManager.beginTransaction()
        h.replace(R.id.content_frame,frag1)
        h.commit()
    }
    fun loadgallary(frag2 : GallaryFragment){
        val h = supportFragmentManager.beginTransaction()
        h.replace(R.id.content_frame,frag2)
        h.commit()
    }
    fun loadshare(frag3 : ShareFragment){
        val h = supportFragmentManager.beginTransaction()
        h.replace(R.id.content_frame,frag3)
        h.commit()
    }
    fun loadlog(frag4 : LogFragment){
        val h = supportFragmentManager.beginTransaction()
        h.replace(R.id.content_frame,frag4)
        h.commit()
    }

}