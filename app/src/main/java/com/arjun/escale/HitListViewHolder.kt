package com.arjun.escale

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arjun.escale.model.Hit
import kotlinx.android.synthetic.main.hit_item.view.*

class HitListViewHolder(
    itemView: View,
    private val interaction: HitListAdapter.Interaction?
) :
    RecyclerView.ViewHolder(itemView) {

    private val title = itemView.hit_title
    private val checkBox = itemView.hit_checkbox

    fun bind(item: Hit?) {
        item?.let { hit ->
            itemView.setOnClickListener {
                interaction?.onItemSelected(absoluteAdapterPosition, hit)
            }

            title.text = hit.title
            checkBox.isUseMaterialThemeColors = true
            checkBox.isChecked = true
        }
    }


    companion object {
        fun create(
            parent: ViewGroup,
            interaction: HitListAdapter.Interaction?
        ): HitListViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.hit_item, parent, false)
            return HitListViewHolder(view, interaction)
        }
    }
}