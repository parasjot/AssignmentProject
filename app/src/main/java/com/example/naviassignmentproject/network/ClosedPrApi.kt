package com.example.naviassignmentproject.network

import com.example.naviassignmentproject.model.ClosedPrModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ClosedPrApi {

    @GET("{ownerName}/{repoName}/pulls?state=closed")
    suspend fun getClosedPrData(@Path("ownerName") ownerName: String, @Path("repoName") repoName: String): Response<ClosedPrModel>
}