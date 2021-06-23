package com.vbuecker.whatdidilearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vbuecker.whatdidilearn.R
import com.vbuecker.whatdidilearn.entities.LearnedItem

class LearnedItemAdapter : RecyclerView.Adapter<LearnedItemAdapter.LearnedItemViewHolder>() {
    var learnedItems = listOf<LearnedItem>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.learned_item, parent, false)
        return LearnedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        val learnedItem = learnedItems[position]
        holder.bind(learnedItem)
    }

    override fun getItemCount(): Int {
        return learnedItems.size
    }

    inner class LearnedItemViewHolder(itemViem: View) : RecyclerView.ViewHolder(itemViem) {
        val viewInflate = itemView.findViewById(R.id.view_colors) as View

        private val titleContainer: TextView = itemViem.findViewById(R.id.learned_title)
        private val descriptionContainer: TextView =
            itemViem.findViewById(R.id.learned_description_text)

        fun bind(learnedItem: LearnedItem) {
            titleContainer.text = learnedItem.name
            descriptionContainer.text = learnedItem.description

            when (learnedItem.understandingLevel.toString()) {
                "LOW" -> viewInflate.setBackgroundResource(R.color.p_light)
                "HIGH" -> viewInflate.setBackgroundResource(R.color.primary_color)
                "MEDIUM" -> viewInflate.setBackgroundResource(R.color.p_darker)
            }
        }
    }

}