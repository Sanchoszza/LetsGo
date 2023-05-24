package com.android.letsgo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.letsgo.R


class RegistrationFragmentKt : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration_kt, container, false)
    }

    companion object {
        val TYPE_INFO = "type_info"
        fun newInstance(type: Int): RegistrationFragmentKt? {
            val args = Bundle()
            args.putInt(TYPE_INFO, type)
            val fragment = RegistrationFragmentKt()
            fragment.setArguments(args)
            return fragment
        }
    }
}