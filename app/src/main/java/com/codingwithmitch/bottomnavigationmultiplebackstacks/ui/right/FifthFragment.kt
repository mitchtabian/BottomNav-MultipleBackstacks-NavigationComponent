package com.codingwithmitch.bottomnavigationmultiplebackstacks.ui.right


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.codingwithmitch.bottomnavigationmultiplebackstacks.R
import com.codingwithmitch.bottomnavigationmultiplebackstacks.UICommunicationListener
import java.lang.ClassCastException

class FifthFragment : Fragment(R.layout.fragment_fifth) {

    private val TAG: String = "AppDebug"

    lateinit var uiCommunicationListener: UICommunicationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this){
            Log.d(TAG, "FifthFragment: handleOnBackPressed")
//            findNavController().popBackStack()
            uiCommunicationListener
                .getCustomBottomNavController()
                .delegateOnBackPressed(findNavController())
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
