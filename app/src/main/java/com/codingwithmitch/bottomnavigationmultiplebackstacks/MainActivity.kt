package com.codingwithmitch.bottomnavigationmultiplebackstacks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.codingwithmitch.bottomnavigationmultiplebackstacks.BottomNavController.*
import com.codingwithmitch.bottomnavigationmultiplebackstacks.ui.left.SecondFragment
import com.codingwithmitch.bottomnavigationmultiplebackstacks.ui.right.FifthFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity() : AppCompatActivity(),
    NavGraphProvider,
    OnNavigationReselectedListener,
    UICommunicationListener
{

    private val TAG: String = "AppDebug"

    private lateinit var bottomNavigationView: BottomNavigationView

    private val bottomNavController by lazy(LazyThreadSafetyMode.NONE) {
        BottomNavController(
            this,
            R.id.main_nav_host_fragment,
            R.id.menu_left_nav,
            this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApplication).appComponent
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigationView()
    }

    private fun setupBottomNavigationView(){
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setUpNavigation(bottomNavController, this)
        bottomNavController.setupBottomNavigationBackStack(null)
        bottomNavController.onNavigationItemSelected()
    }

    override fun getNavGraphId(itemId: Int) = when(itemId){
        R.id.menu_left_nav -> {
            R.navigation.left_nav
        }
        R.id.menu_middle_nav -> {
            R.navigation.middle_nav
        }
        R.id.menu_right_nav -> {
            R.navigation.right_nav
        }
        else -> {
            R.navigation.left_nav
        }
    }

    override fun onReselectNavItem(
        navController: NavController,
        fragment: Fragment
    ){
        when(fragment){

            is SecondFragment -> {
                navController.navigate(R.id.action_secondFragment_to_firstFragment)
            }

            is FifthFragment -> {
                navController.navigate(R.id.action_fifthFragment_to_fourthFragment)
            }

            else -> {
                // do nothing
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun getCustomBottomNavController(): BottomNavController {
        return bottomNavController
    }

}


















