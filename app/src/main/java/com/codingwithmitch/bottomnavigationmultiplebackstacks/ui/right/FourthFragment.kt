package com.codingwithmitch.bottomnavigationmultiplebackstacks.ui.right


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.codingwithmitch.bottomnavigationmultiplebackstacks.R
import com.codingwithmitch.bottomnavigationmultiplebackstacks.UICommunicationListener
import kotlinx.android.synthetic.main.fragment_fourth.*
import java.lang.ClassCastException

class FourthFragment : Fragment(R.layout.fragment_fourth) {

    private val TAG: String = "AppDebug"

    lateinit var uiCommunicationListener: UICommunicationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this){
            Log.d(TAG, "FourthFragment: handleOnBackPressed")
            uiCommunicationListener
                .getCustomBottomNavController()
                .onBackPressed()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fourth.setOnClickListener {
            findNavController().navigate(R.id.action_fourthFragment_to_fifthFragment)
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
















