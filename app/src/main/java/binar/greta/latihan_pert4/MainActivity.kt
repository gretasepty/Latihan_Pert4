package binar.greta.latihan_pert4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import binar.greta.latihan_pert4.data.ResponseStafItem
import binar.greta.latihan_pert4.ui.theme.Latihan_Pert4Theme
import binar.greta.latihan_pert4.viewmodel.StafVM
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Latihan_Pert4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val stafVM = viewModel(modelClass = StafVM::class.java)
                    val datastaf by stafVM.datastate.collectAsState()
                    
                    LazyColumn{
                        if (datastaf.isEmpty()){
                            item{
                                
                            }
                        }
                        
                        items(datastaf){
                            Greeting(staf = it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(staf: ResponseStafItem) {

    Column(modifier = Modifier.padding(15.dp)) {
        Card(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Row() {
                Image(
                    painter = rememberImagePainter(data = staf.image),
                    contentDescription = "icon",
                    modifier = Modifier.height(50.dp)
                )
                Column(modifier = Modifier.padding(start = 15.dp)) {
                    Text(text = staf.name)
                    Text(text = staf.email)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Latihan_Pert4Theme {
//        Greeting("Android")
    }
}