package com.arjun.escale

import android.os.Bundle
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
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: HitViewModel by viewModels()
    private val hitListAdapter: HitListAdapter by lazy {
        HitListAdapter(object : HitListAdapter.Interaction {
            override fun onItemSelected(position: Int, item: Hit) {
                Timber.d(item.title)
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
                    RecyclerView.HORIZONTAL
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
}