package View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,

                        ){
                        Text(text = "Home", fontWeight = FontWeight.ExtraBold)
                    }
                }
            )
        },

        ) { innerPadding ->
        HomeAccueil(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun HomeAccueil(modifier: Modifier) {
    Row (
        modifier.padding(10.dp)
    ){
        Text(text = "Bienvenue dans la page Home", fontWeight = FontWeight.ExtraBold)
    }

}
