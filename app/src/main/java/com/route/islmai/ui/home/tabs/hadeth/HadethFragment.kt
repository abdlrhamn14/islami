package com.route.islmai.ui.home.tabs.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islmai.databinding.FragmentHadthBinding


class HadethFragment : Fragment() {

    lateinit var viewBinding: FragmentHadthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadthBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return viewBinding.root
    }


}