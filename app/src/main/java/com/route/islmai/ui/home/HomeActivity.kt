package com.route.islmai.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islmai.R
import com.route.islmai.databinding.ActivityHomeBinding
import com.route.islmai.ui.home.tabs.hadeth.HadethFragment
import com.route.islmai.ui.home.tabs.quran.QuranFragment
import com.route.islmai.ui.home.tabs.radio.RadioFragment
import com.route.islmai.ui.home.tabs.tasbeh.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.content.BottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {//any click on them will open fragment so we can make a function
                R.id.quran_nav -> StartNewFragment(QuranFragment())

                R.id.ahdeth_nav -> StartNewFragment(HadethFragment())

                R.id.radio_nav -> StartNewFragment(RadioFragment())

                R.id.tasbeh_nav -> StartNewFragment(TasbehFragment())

            }
            true
            //this mean item is selected
        }
        viewBinding.content.BottomNavigationView.selectedItemId = R.id.quran_nav
    }

    fun StartNewFragment(fragmentType: Fragment) {
        //polymorphism  because i don't know what i will send as fragment
        //but i know it's a fragment which is parent
        //so i take an object from type fragment whatever it was(quran fragment,hadteh,tasbeh,radio)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view_tag, fragmentType).commit()

    }


}