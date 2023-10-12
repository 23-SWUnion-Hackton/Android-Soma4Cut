package com.staker4wapper.android_soma4cut.feature.somaspace.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.domain.model.space.Image

class SomaSpaceImageListAdapter(
    private val itemList: List<Image>,
    private val context: Context,
) : RecyclerView.Adapter<SomaSpaceImageListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        Glide.with(context).load(item.images[0]).into(holder.somaSpaceImage1)
        Glide.with(context).load(item.images[1]).into(holder.somaSpaceImage2)
        Glide.with(context).load(item.images[2]).into(holder.somaSpaceImage3)
        Glide.with(context).load(item.images[3]).into(holder.somaSpaceImage4)
    }

    override fun getItemCount(): Int = itemList.size

    class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val somaSpaceImage1: ImageView = itemView.findViewById(R.id.iv_soma_image1)
        val somaSpaceImage2: ImageView = itemView.findViewById(R.id.iv_soma_image2)
        val somaSpaceImage3: ImageView = itemView.findViewById(R.id.iv_soma_image3)
        val somaSpaceImage4: ImageView = itemView.findViewById(R.id.iv_soma_image4)
    }

}