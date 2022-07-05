package com.example.naviassignmentproject.network

import android.util.Log
import com.example.naviassignmentproject.model.ClosedPrModel
import com.example.naviassignmentproject.model.ClosedPrModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ClosedPrNetworkManager {
    private val closedPrApi = RetrofitHelper.getInstance().create(ClosedPrApi::class.java)

    //send request params
    open suspend fun getClosedPrList() : List<ClosedPrModelItem>? {
        val result : Response<ClosedPrModel> = closedPrApi.getClosedPrData()
        return if(result.isSuccessful){
            Log.e("Paras ", result.body().toString())
            result.body()
        } else {
            null;
        }
    }
}