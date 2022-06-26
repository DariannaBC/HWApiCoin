package com.itsecurity.hwapicoin.data.remote

import com.itsecurity.hwapicoin.data.remote.dto.CoinDto
import retrofit2.http.GET

interface CoinApi {
    @GET("/Coins")
    suspend fun getExchange(): List<CoinDto>
}