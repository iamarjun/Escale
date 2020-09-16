package com.arjun.escale

import android.content.Context
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arjun.escale.model.Hit
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: HitViewModel by viewModels()
    private val list: ArrayList<Hit> by lazy { ArrayList() }
    private val hitListAdapter: HitListAdapter by lazy {
        HitListAdapter(object : HitListAdapter.Interaction {
            override fun onItemSelected(position: Int, item: Hit) {
                if (!list.contains(item) && item.isSelected)
                    list.add(item)
                else {
                    if (!item.isSelected)
                        list.remove(item)
                }

                invalidateOptionsMenu()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hit_list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL
                )
            )
            adapter = hitListAdapter
        }


        lifecycleScope.launch {
            viewModel.hits.collectLatest {
                hitListAdapter.submitData(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.actionbar_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        setCount(this, menu)
        return true
    }

    private fun setCount(context: Context, menu: Menu?) {
        val menuItem = menu?.findItem(R.id.ic_group)
        val icon = menuItem?.icon as LayerDrawable
        val badge: CountDrawable

        // Reuse drawable if possible
        val reuse = icon.findDrawableByLayerId(R.id.ic_group_count)
        badge = if (reuse != null && reuse is CountDrawable) {
            reuse
        } else {
            CountDrawable(context)
        }
        badge.setCount(list.size.toString())
        icon.mutate()
        icon.setDrawableByLayerId(R.id.ic_group_count, badge)
    }
}