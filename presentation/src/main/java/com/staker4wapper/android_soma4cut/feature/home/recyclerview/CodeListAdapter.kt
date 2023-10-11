package com.staker4wapper.android_soma4cut.feature.home.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.staker4wapper.android_soma4cut.R

class CodeListAdapter(
    private val itemList: List<String>,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<CodeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_saved_code, parent, false)

        return ViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        holder.codeText.text = item
    }

    override fun getItemCount(): Int = itemList.size

    class ViewHolder(
        itemView: View,
        private val onItemClickListener: OnClickListener
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init { itemView.setOnClickListener(this) }

        val codeText: TextView = itemView.findViewById(R.id.tv_code)

        override fun onClick(p0: View?) {
            onItemClickListener.onMyAccountItemClick(adapterPosition)
        }
    }

    interface OnClickListener {
        fun onMyAccountItemClick(position: Int)
    }


}