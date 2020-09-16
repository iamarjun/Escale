package com.arjun.escale

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arjun.escale.model.Hit

class HitListAdapter(
    private val interaction: Interaction?
) :
    PagingDataAdapter<Hit, RecyclerView.ViewHolder>(HIT_COMPARATOR) {

    interface Interaction {
        fun onItemSelected(position: Int, item: Hit)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HitListViewHolder.create(parent, interaction)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HitListViewHolder).bind(getItem(position))
    }

    companion object {
        private val HIT_COMPARATOR = object : DiffUtil.ItemCallback<Hit>() {

            override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
                return oldItem.objectID == newItem.objectID
            }

            override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
                return oldItem == newItem
            }
        }
    }

}

