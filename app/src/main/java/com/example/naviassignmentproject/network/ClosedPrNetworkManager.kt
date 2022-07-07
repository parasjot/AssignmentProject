package com.example.naviassignmentproject.network

import android.util.Log
import com.example.naviassignmentproject.model.ClosedPrModel
import com.example.naviassignmentproject.model.ClosedPrModelItem
import retrofit2.Response

object ClosedPrNetworkManager {
    private val closedPrApi = RetrofitHelper.getInstance().create(ClosedPrApi::class.java)
    private const val ownerName = "square"
    private const val repoName = "okhttp"

    //send request params
    open suspend fun getClosedPrList(): List<ClosedPrModelItem>? {
        val result: Response<ClosedPrModel> = closedPrApi.getClosedPrData(ownerName, repoName)
        return if (result.isSuccessful) {
            Log.e("Paras ", result.body().toString())
            result.body()
        } else {
            null;
        }
    }
}