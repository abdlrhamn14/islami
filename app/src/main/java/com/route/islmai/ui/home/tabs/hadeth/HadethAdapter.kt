package com.route.islmai.ui.home.tabs.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islmai.databinding.HadethItemBinding
import com.route.islmai.ui.home.model.Hadeth

class HadethAdapter(var hadethes: List<Hadeth>?) :
    RecyclerView.Adapter<HadethAdapter.ViewHolder>() {
    class ViewHolder(var binding: HadethItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    var onItemClickLisenter: OnItemClickLisenter? = null

    //it already has getter and setter
    fun interface OnItemClickLisenter {
        fun onClick(position: Int, hadeth: Hadeth?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HadethItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hadethes?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.itemHadethRecycle.text = hadethes?.get(position)?.title
        if (onItemClickLisenter != null) {
            holder.binding.root.setOnClickListener {
                onItemClickLisenter?.onClick(position, hadethes?.get(position))

            }
        }
    }

    fun bindHadethes(newList: List<Hadeth>) {
        hadethes = newList
        notifyDataSetChanged()
    }
}