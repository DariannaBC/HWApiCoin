package com.itsecurity.hwapicoin.data.remote

import com.itsecurity.hwapicoin.data.remote.dto.CoinsDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CoinsApi {
    @GET("/Coins")
    suspend fun getCoins(): List<CoinsDto>

    @POST("/Coins/PostCoins")
    suspend fun postCoins(@Body coins: CoinsDto): CoinsDto
}