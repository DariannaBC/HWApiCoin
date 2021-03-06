package com.itsecurity.hwapicoin.ui.theme.Coin

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.itsecurity.hwapicoin.data.remote.dto.CoinDto
import com.itsecurity.hwapicoin.model.CoinViewModel



@Composable
fun CoinListScreen(
    navHostController: NavHostController,
    viewModel: CoinViewModel = hiltViewModel()
){

    val ScaffoldState = rememberScaffoldState()



    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Coins")}
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate("RegistroCoins")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        scaffoldState = ScaffoldState

    ) {it

        val state = viewModel.state.value
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items( state.exchange){ exchange ->
                    CoinItem(coin = exchange, {})
                }
            }

            if (state.isLoading)
                CircularProgressIndicator()

        }
    }

}

@Composable
fun CoinItem(
    coin: CoinDto,
    onClick : (CoinDto) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick(coin) }
        .padding(16.dp)
    ) {
        Text(
            text = "${coin.descripcion}",
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            modifier = Modifier.fillMaxWidth()
                .height(30.dp).padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${coin.valor}",
                color = Color.Cyan,
                fontStyle = FontStyle.Normal,
                style = MaterialTheme.typography.body1,
            )
            Image(
                painter = rememberAsyncImagePainter(coin.imageUrl),
                contentDescription = null,
                modifier = Modifier.size(128.dp),
            )
        }

    }
}
