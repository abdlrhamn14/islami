package com.route.islmai.ui.home.tabs.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islmai.databinding.FragmentRadioBinding


class RadioFragment : Fragment() {
    lateinit var viewBinding: FragmentRadioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentRadioBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return viewBinding.root
    }


}