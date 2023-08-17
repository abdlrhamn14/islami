package com.route.islmai.ui.chapterDetalies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islmai.databinding.ActivityChapterDetaliesBinding
import com.route.islmai.ui.Constants

class ChapterDetalies : AppCompatActivity() {
    lateinit var adapter: VersesAdapter
    lateinit var name: String
    var index: Int = 0
    lateinit var viewBinding: ActivityChapterDetaliesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChapterDetaliesBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initPrams()
        loadChapterFile()
        initViews()
    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
        viewBinding.nameOfSura.text = name
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        //finish your activity
        return true
    }

    private fun loadChapterFile() {
        //this function will return whole file and we will take it and segregate it line by line
        var suraContent = assets.open("$index.txt").bufferedReader().use { it.readText() }
        var lines = suraContent.trim().split("\n")
        bindVerses(lines)
        //trim remove white spaces
        //split return a list of the string segregated line by line

    }

    private fun bindVerses(lines: List<String>) {
        adapter = VersesAdapter(lines)
        viewBinding.content.versesRecycle.adapter = adapter

    }


    private fun initPrams() {
        //he will be upset because if he found notingg is sended he will return null
        //and he  is not nullable so i  put default value
        name = intent.getStringExtra(Constants.EXTRA_CHAPTER_NAME) ?: ""
        index = intent.getIntExtra(Constants.EXTRA_CHAPTER_INDEX, 0)
    }
}