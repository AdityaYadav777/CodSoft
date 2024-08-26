package com.aditya.noteapp_codsoft.Screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aditya.noteapp_codsoft.MVVM.MainViewModel
import com.aditya.noteapp_codsoft.Room.NoteEntity


@Composable
fun CreateNote(viewModel: MainViewModel, navController: NavHostController) {

    var title by remember {
        mutableStateOf("")
    }

    var data by remember {
        mutableStateOf("")
    }
    val context= LocalContext.current


    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        OutlinedTextField(value = title, onValueChange ={
            title=it
        } )

     Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = data, onValueChange ={
            data=it
        } )
        Spacer(modifier = Modifier.height(20.dp))


         Button(onClick = {
             saveData(viewModel,title,data,context)
             navController.popBackStack()
         }) {
             Text(text = "Create")

         }

    }
}

fun saveData(viewModel: MainViewModel, title: String, data: String, context: Context) {

    val data=NoteEntity(title,data)
    viewModel.insertData(data,context)



}
