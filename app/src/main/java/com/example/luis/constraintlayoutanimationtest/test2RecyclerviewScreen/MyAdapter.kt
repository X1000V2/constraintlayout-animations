package com.example.luis.constraintlayoutanimationtest.test2RecyclerviewScreen

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.luis.constraintlayoutanimationtest.R
import java.util.zip.Inflater

class MyAdapter(var items: List<ItemData>) : RecyclerView.Adapter<MyAdapter.CustomView>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CustomView {
       val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list, parent, false)
        return CustomView(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewHolder: CustomView, position: Int) {

        viewHolder.bind(items[position])
        Animation.animate(items[position].showInfo,viewHolder)

    }


    class CustomView(view: View): RecyclerView.ViewHolder(view) {
        val context = view.context
        val textTitle = view.findViewById<TextView>(R.id.item_title)
        val constraintLayoutRoot = view.findViewById<ConstraintLayout>(R.id.item_list_row)

        fun bind(item: ItemData){
            textTitle.text = item.item

            itemView.setOnClickListener {
                item.showInfo = !item.showInfo
                Animation.animate(item.showInfo,this)
            }
        }
    }
}