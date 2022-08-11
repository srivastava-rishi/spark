package com.rsstudio.spark.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.makeramen.roundedimageview.RoundedImageView
import com.rsstudio.spark.R
import com.rsstudio.spark.model.Info
import com.rsstudio.spark.model.ProductsData


class MainAdapter(
    private var context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() , Filterable {

    private var list: MutableList<ProductsData> = mutableListOf()

    private var productFilteredList: MutableList<Info> = mutableListOf()

    var logTag = "@MainAdapter"

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tvProductName: TextView = view.findViewById(R.id.tvProductName)
        private var tvProductDescription: TextView = view.findViewById(R.id.tvProductDescription)
        var tvCategory: TextView = view.findViewById(R.id.tvCategory)
        var tvRating: TextView = view.findViewById(R.id.tvRating)
        var rivBeerImage: RoundedImageView = view.findViewById(R.id.rivProductImage)
        var cvContainer: CardView = view.findViewById(R.id.cvContainer)

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

        val item = productFilteredList[position]
        if (holder is MainAdapter.ItemViewHolder) {
            holder.cvContainer.animation = AnimationUtils.loadAnimation(context,R.anim.anim_fade_scale)
            holder.onBind(item)
        }
    }

    fun submitList(newList: List<ProductsData>) {
        list.clear()
        productFilteredList.clear()
        list.addAll(newList)
        productFilteredList.addAll(list[0].products)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        if (productFilteredList.size != 0) {
            return productFilteredList.size
        }
        return 0
    }

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {

                val charString = constraint?.toString() ?: ""

                if(charString.isEmpty()){
                    productFilteredList.clear()
                    productFilteredList.addAll(list[0].products)
                } else{

                    var filteredList:  MutableList<Info> = mutableListOf()

                    list[0].products.filter {
                        (it.title.lowercase().contains(constraint.toString().lowercase().trim()))
                    }.forEach{ filteredList.add(it)}
                    productFilteredList = filteredList
                }

                return FilterResults().apply { values = productFilteredList }

            }
            override fun publishResults(constraint: CharSequence, results: FilterResults?) {
                if (results!!.values != null) {
                    productFilteredList = results.values as MutableList<Info>
                    notifyDataSetChanged()
                }

            }
        }
    }
}


