package com.android.letsgo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.android.letsgo.R
import com.android.letsgo.activity.MainActivity


class ChooseTypeRegFragment : Fragment() {

    private lateinit var btnPassenger: Button
    private lateinit var btnDriver: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choose_type_reg, container, false)

        btnPassenger = view.findViewById(R.id.passenger)
        btnDriver = view.findViewById(R.id.driver)

        btnPassenger.setOnClickListener{
            (activity as MainActivity?)!!.replaceFragment(RegistrationFragmentKt.Companion.newInstance(0), false)
        }

        btnDriver.setOnClickListener{
            (activity as MainActivity?)!!.replaceFragment(RegistrationFragmentKt.Companion.newInstance(1), false)
        }

//        val logInNow: TextView = view.findViewById(R.id.loginNowBtn)
//        logInNow.setOnClickListener{
//            (activity as MainActivity?)!!.replaceFragment(LoginFragmentKt.newInstance(), true)
//        }
        return view
    }

    companion object {
        fun newInstance() : ChooseTypeRegFragment{
            return ChooseTypeRegFragment()
        }
    }
}