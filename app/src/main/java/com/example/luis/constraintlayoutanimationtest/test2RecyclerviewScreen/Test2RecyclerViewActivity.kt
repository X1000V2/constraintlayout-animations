package com.example.luis.constraintlayoutanimationtest.test2RecyclerviewScreen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.luis.constraintlayoutanimationtest.R
import kotlinx.android.synthetic.main.test_2_recyclerview_activity.*

class Test2RecyclerViewActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.test_2_recyclerview_activity)

        val list: List<ItemData> = (0..10).toList().map { ItemData("Item $it",false) }

        val viewManager = LinearLayoutManager(this)
        val viewAdapter = MyAdapter(list)

        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

        button_show.setOnClickListener {
            //show list details
            list.forEach { it.showInfo = !it.showInfo }
            viewAdapter.items = list

            (0..list.size).forEach { viewAdapter.notifyItemChanged(it) }

        }

    }
}