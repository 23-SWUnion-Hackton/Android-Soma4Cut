package com.staker4wapper.android_soma4cut.feature.somaspace.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.staker4wapper.android_soma4cut.R

class SomaSpaceImageListAdapter(
    private val itemList: List<Int>
) : RecyclerView.Adapter<SomaSpaceImageListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        holder.somaSpaceImage.setImageResource(item)
    }

    override fun getItemCount(): Int = itemList.size

    class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val somaSpaceImage: ImageView = itemView.findViewById(R.id.iv_soma_space_image)
    }

}