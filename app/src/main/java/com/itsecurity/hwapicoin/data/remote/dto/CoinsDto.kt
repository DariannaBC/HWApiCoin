package com.itsecurity.hwapicoin.data.remote.dto

data class CoinsDto(
    val coinId: Int,
    val descripcion: String,
    val valor: Float,
    val imagenUrl: String?
)