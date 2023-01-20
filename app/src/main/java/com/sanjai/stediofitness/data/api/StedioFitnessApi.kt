package com.sanjai.stediofitness.data.api

import com.sanjai.stediofitness.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StedioFitnessApi {

    @GET("/cardio")
    suspend fun getAllCardio(): ApiResponse

    @GET("/strength")
    suspend fun getAllStrengthening(): ApiResponse

    @GET("/strengthClasses")
    suspend fun getAllStrengthening(
        @Query("classId") classId: Int
    ): ApiResponse

}