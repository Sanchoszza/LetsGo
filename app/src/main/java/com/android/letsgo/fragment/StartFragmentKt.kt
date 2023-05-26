package com.android.letsgo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.android.letsgo.R
import com.android.letsgo.activity.MainActivity

class StartFragmentKt : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start_kt, container, false)

        val regBtn: Button = view.findViewById(R.id.reg_btn)
        regBtn.setOnClickListener{
            (activity as MainActivity?)!!.replaceFragment(ChooseTypeRegFragment.newInstance(), true)
        }

        val logBtn: Button = view.findViewById(R.id.log_btn)
        logBtn.setOnClickListener{
            (activity as MainActivity?)!!.replaceFragment(LoginFragmentKt.newInstance(), true)
        }
        return view
    }

    companion object {
        fun newInstance(): StartFragmentKt? {
            return StartFragmentKt()
        }
    }
}