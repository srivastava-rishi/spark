package com.rsstudio.spark.adapter

import com.rsstudio.spark.R
import com.rsstudio.spark.model.ProductsData
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.makeramen.roundedimageview.RoundedImageView
import com.rsstudio.spark.model.Info

class MainAdapter(
    private var context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<ProductsData> = mutableListOf()

    var logTag = "@MainAdapter"

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tvProductName: TextView = view.findViewById(R.id.tvProductName)
        private var tvProductDescription: TextView = view.findViewById(R.id.tvProductDescription)
        var tvCategory: TextView = view.findViewById(R.id.tvCategory)
        var tvRating: TextView = view.findViewById(R.id.tvRating)
        var rivBeerImage: RoundedImageView = view.findViewById(R.id.rivProductImage)

        @SuppressLint("SetTextI18n")
        fun onBind(item: Info) {

            tvProductName.text = item.title
            tvProductDescription.text = item.description
            tvCategory.text = item.category
            tvRating.text = item.rating.toString()

            // setting image
            Glide
                .with(context)
                .load(item.images[0])
                .thumbnail(0.7f)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(rivBeerImage)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_product_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[0].products[position]
        if (holder is MainAdapter.ItemViewHolder) {
            holder.onBind(item)
        }
    }

    fun submitList(newList: List<ProductsData>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        if (list.size != 0) {
            return list[0].products.size
        }
        return 0
    }
}


