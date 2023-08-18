package com.route.islmai.ui.hadethDeatalies

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islmai.databinding.ActivityHadethAcivityBinding
import com.route.islmai.ui.Constants
import com.route.islmai.ui.home.model.Hadeth

class HadethAcivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethAcivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethAcivityBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        getIntentHadeth()
        bindHadeth()
        initView()

    }

    private fun bindHadeth() {
        viewBinding.nameOfHadeth.text = hadeth?.title
        viewBinding.content.txtContent.text = hadeth?.content
    }

    private fun initView() {//back button
        setSupportActionBar(viewBinding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)//to show arrow
        supportActionBar?.setDisplayShowHomeEnabled(true)// to make action
        supportActionBar?.title = ""

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    var hadeth: Hadeth? = null
    private fun getIntentHadeth() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getSerializableExtra(Constants.EXTRA_HADETH) as Hadeth
        } else {
            hadeth = intent.getSerializableExtra(Constants.EXTRA_HADETH) as Hadeth?
            //casting

        }
    }
}