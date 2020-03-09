package com.codingwithmitch.bottomnavigationmultiplebackstacks.ui.right


import android.os.Bundle
import android.util.Log
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.codingwithmitch.bottomnavigationmultiplebackstacks.R

class FifthFragment : Fragment(R.layout.fragment_fifth) {

    private val TAG: String = "AppDebug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this){
            Log.d(TAG, "FifthFragment: handleOnBackPressed")
            findNavController().popBackStack()
        }
    }

}
