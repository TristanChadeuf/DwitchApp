package View

import androidx.compose.foundation.background
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
import com.example.dwitchapp.ui.theme.OpenColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen() {

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
                        Text(text = "News", fontWeight = FontWeight.ExtraBold)
                    }
                }
            )
        },
    ) { innerPadding ->
        NewsAccueil(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun NewsAccueil(modifier: Modifier) {
    Row (
        modifier.padding(10.dp)
    ){
        Text(text = "Bienvenue dans la page News", fontWeight = FontWeight.ExtraBold)
    }


}




