package com.codingwithmitch.bottomnavigationmultiplebackstacks.ui.left


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.codingwithmitch.bottomnavigationmultiplebackstacks.R
import com.codingwithmitch.bottomnavigationmultiplebackstacks.UICommunicationListener
import kotlinx.android.synthetic.main.fragment_first.*
import java.lang.ClassCastException


class FirstFragment : Fragment(R.layout.fragment_first) {

    private val TAG: String = "AppDebug"

    lateinit var uiCommunicationListener: UICommunicationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this){
            Log.d(TAG, "FirstFragment: handleOnBackPressed")
            uiCommunicationListener
                .getCustomBottomNavController()
                .onBackPressed()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        first.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
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




















