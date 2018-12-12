package com.mobile.app.pagingexample

import android.util.Log
import androidx.paging.PositionalDataSource

class MainDataSource : PositionalDataSource<Int>(){
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Int>) {
        callback.onResult(mutableListOf(
            params.startPosition+1,
            params.startPosition+2,
            params.startPosition+3,
            params.startPosition+4,
            params.startPosition+5,
            params.startPosition+6,
            params.startPosition+7,
            params.startPosition+8,
            params.startPosition+9,
            params.startPosition+10,
            params.startPosition+11,
            params.startPosition+12,
            params.startPosition+13,
            params.startPosition+14,
            params.startPosition+15,
            params.startPosition+16,
            params.startPosition+17,
            params.startPosition+18,
            params.startPosition+19,
            params.startPosition+20
        ))
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Int>) {
        val firstLoadPosition = PositionalDataSource.computeInitialLoadPosition(params, 20)
        val firstLoadSize = PositionalDataSource.computeInitialLoadSize(params, firstLoadPosition, 654)
        Log.d("DataSource", "b $firstLoadPosition + ${firstLoadPosition + firstLoadSize}")
        callback.onResult(mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20),0,654)
    }
}