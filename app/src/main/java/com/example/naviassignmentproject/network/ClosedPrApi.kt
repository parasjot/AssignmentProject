package com.example.naviassignmentproject.network

import com.example.naviassignmentproject.model.ClosedPrModel
import retrofit2.Response
import retrofit2.http.GET

interface ClosedPrApi {

    @GET("parasjot/NaviAssignmentProject/pulls?state=closed")
    suspend fun getClosedPrData(): Response<ClosedPrModel>
}