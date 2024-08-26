package com.aditya.noteapp_codsoft.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aditya.noteapp_codsoft.MVVM.MainViewModel
import com.aditya.noteapp_codsoft.Room.NoteEntity
import com.aditya.noteapp_codsoft.Routes
import com.aditya.noteapp_codsoft.Utils


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(viewModel: MainViewModel, navController: NavHostController) {

 val context= LocalContext.current

val noteData=viewModel .getData(context).observeAsState()
 val data=noteData.value?: emptyList()



Scaffold { innerpadding->
 Modifier.padding(innerpadding)
 val state= rememberScrollState()




  Column(modifier = Modifier
   .padding()
   .fillMaxSize()) {

  TopAppBar(title = { Text("Note- App") },
modifier = Modifier
 .fillMaxWidth(),
   colors = TopAppBarDefaults.topAppBarColors(Color.Cyan),
  )




  LazyVerticalGrid(columns = GridCells.Fixed(2)) {
items(data){
 DikhaDo(it,navController)

}
  }
  
 }
}
 Column(modifier = Modifier
  .fillMaxSize()
  .padding(26.dp),
  horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Bottom) {
  FloatingActionButton(onClick = { navController.navigate(Routes.Create.routes) }) {
   Text(text = "+")
  }

 }
}

@Composable
fun DikhaDo(data: NoteEntity, navController: NavHostController) {
 Card (shape = RoundedCornerShape(0.dp),
  modifier = Modifier
   .width(130.dp)
   .height(200.dp)
   .padding(8.dp)
   .background(Color.Gray)
   .clickable {
    Utils.noteData = data
    navController.navigate(Routes.UpdateScreen.routes)
   },
  ){

  Column (modifier = Modifier.fillMaxSize(),
   horizontalAlignment = Alignment.CenterHorizontally,
   verticalArrangement = Arrangement.Center){
   Row {
    Text(text = data.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
   }
   Row {
    Text(text = data.data)
   }
  }

  
  
 }




}



@Preview
@Composable
fun Preview(){
 Home(viewModel = MainViewModel(), navController = rememberNavController())

}