package com.mobile.app.pagingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(20)
            .setPageSize(20)
            .setPrefetchDistance(5)
            .setEnablePlaceholders(true)
            .build()
        val builder = RxPagedListBuilder<Int,Int>(object : DataSource.Factory<Int,Int>(){
            override fun create(): DataSource<Int, Int> {
                return MainDataSource()
            }
        },config)
        val mainAdapter = MainAdapter()
        recycler.apply {
            adapter = mainAdapter
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,3)
            addItemDecoration(SpacesItemDecoration(3,30))
        }
        builder.buildObservable().subscribe { mainAdapter.submitList(it) }
    }
}
