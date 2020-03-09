package com.codingwithmitch.bottomnavigationmultiplebackstacks.ui.middle


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.addCallback
import androidx.fragment.app.Fragment

import com.codingwithmitch.bottomnavigationmultiplebackstacks.R
import com.codingwithmitch.bottomnavigationmultiplebackstacks.UICommunicationListener
import java.lang.ClassCastException

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private val TAG: String = "AppDebug"

    lateinit var uiCommunicationListener: UICommunicationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this){
            Log.d(TAG, "ThirdFragment: handleOnBackPressed")
            uiCommunicationListener
                .getCustomBottomNavController()
                .onBackPressed()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            uiCommunicationListener = (context as UICommunicationListener)
        }catch (e: ClassCastException){
            e.printStackTrace()
        }
    }

}
