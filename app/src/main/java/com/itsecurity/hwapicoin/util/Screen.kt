package com.itsecurity.hwapicoin.util

sealed class Screen(val route: String) {
    object coinsRegistroScreen: Screen("coinsRegistroScreen")
    object coinsListadoScreen: Screen("coinsListadoScreen")
}