package com.route.islmai.ui.home.tabs.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islmai.databinding.FragmentHadthBinding
import com.route.islmai.ui.Constants
import com.route.islmai.ui.hadethDeatalies.HadethAcivity
import com.route.islmai.ui.home.model.Hadeth


class HadethFragment : Fragment() {
    var hadethes = mutableListOf<Hadeth>()
    lateinit var viewBinding: FragmentHadthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadthBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    lateinit var adapter: HadethAdapter
    private fun initViews() {
        //onViewCreated called before onStart so adapter will not get his list so i will send it at first by null
        adapter = HadethAdapter(null)
        adapter.onItemClickLisenter = HadethAdapter.OnItemClickLisenter {
            // lamda experssion with kotlin interface
                position, hadeth ->
            showHadeth(hadeth)

        }

    }

    private fun showHadeth(hadeth: Hadeth?) {
        val intent = Intent(activity, HadethAcivity::class.java)
        intent.putExtra(Constants.EXTRA_HADETH, hadeth)
        startActivity(intent)

    }


    override fun onStart() {
        super.onStart()
        loadHadethFile()
        bindItems(hadethes)
        viewBinding.recyclerviewHadethFragment.adapter = adapter


    }

    private fun bindItems(hadethes: MutableList<Hadeth>) {
        adapter.bindHadethes(hadethes)
    }

    private fun loadHadethFile() {
        val fileContent =
            requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val eachIndexIsHadeth = fileContent.trim().split("#")
        eachIndexIsHadeth.forEach { element ->
            val lines = element.trim().split("\n")
            val title = lines[0]
            val content = lines.joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethes.add(hadeth)
        }

    }


}