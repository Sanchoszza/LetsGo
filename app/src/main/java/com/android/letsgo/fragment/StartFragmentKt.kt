package com.android.letsgo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.letsgo.R

class StartFragmentKt : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_kt, container, false)
    }

    companion object {
        fun newInstance(): StartFragmentKt? {
            return StartFragmentKt()
        }
    }
}