package com.route.islmai.ui.chapterDetalies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islmai.databinding.ItemVerseBinding

class VersesAdapter(val verses: List<String>) : RecyclerView.Adapter<VersesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVerseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return verses.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.versesRecycle.text = verses[position]
    }

    class ViewHolder(val viewBinding: ItemVerseBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    }

}