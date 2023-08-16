package com.route.islmai.ui.home.tabs.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islmai.databinding.FragmentTashehBinding


class TasbehFragment : Fragment() {
    lateinit var viewBinding: FragmentTashehBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTashehBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return viewBinding.root
    }


}