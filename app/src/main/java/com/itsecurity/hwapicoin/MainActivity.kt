package com.itsecurity.hwapicoin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.itsecurity.hwapicoin.ui.theme.Componentes.listadoCoins
import com.call.coinscompose.ui.theme.Componentes.registroCoins
import com.call.coinscompose.util.Screen
import com.itsecurity.hwapicoin.ui.theme.HWApiCoinTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           myApp()
        }
    }
}

@Composable
fun myApp() {
    HWApiCoinTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navHostController = rememberNavController()
            NavHost(navController = navHostController,
                startDestination = Screen.coinsListadoScreen.route){

                composable(route  = Screen.coinsListadoScreen.route){
                    listadoCoins(goToRegistro = {navHostController.navigate(Screen.coinsRegistroScreen.route)})
                }
                
                composable(route = Screen.coinsRegistroScreen.route){
                    registroCoins(backToListado = {navHostController.navigate(Screen.coinsListadoScreen.route)})
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HWApiCoinTheme {
        myApp()
    }
}