package com.itsecurity.hwapicoin.data

import com.example.coin_api_as.data.remote.dto.CoinDto

data class CoinListState(
    val isLoading: Boolean = false,
    val exchange: List<CoinDto> = emptyList(),
    val error: String = ""
)