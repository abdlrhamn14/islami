package com.route.islmai.ui.home.tabs.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islmai.databinding.ItemChapterQuranBinding

class ChapterNameRecyclerAdapter(private val name: List<String>) :
    RecyclerView.Adapter<ChapterNameRecyclerAdapter.ViewHolder>() {
    class ViewHolder(val viewBinding: ItemChapterQuranBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    }

    var onItemClickLisenter: OnItemClickLisenter? = null

    //it already has getter and setter
    interface OnItemClickLisenter {
        fun onClick(position: Int, name: String) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemChapterQuranBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = name.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.nameOfChapter.text = name[position]
        if (onItemClickLisenter != null) {
            holder.viewBinding.root.setOnClickListener {
                onItemClickLisenter?.onClick(
                    position, name[position]
                )
            }
        }

    }
}