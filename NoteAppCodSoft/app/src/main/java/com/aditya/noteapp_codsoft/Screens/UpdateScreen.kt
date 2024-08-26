package com.aditya.noteapp_codsoft.Screens

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import com.aditya.noteapp_codsoft.Utils


@Composable
fun UpdateScreen(viewModel: MainViewModel, navController: NavHostController) {

    var id: Int = 0
    val context = LocalContext.current

    val data = Utils.noteData

    var upTitle by remember {
        mutableStateOf("")
    }

    var upData by remember {
        mutableStateOf("")
    }

    if (data != null) {
        upTitle = data.title
        upData = data.data
        id = data.id

    }


    Surface {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            OutlinedTextField(value = upTitle, onValueChange = {
                upTitle = it
            })
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(value = upData, onValueChange = {
                upData = it
            })

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                updateData(context, upData, upTitle, id, viewModel)

            }) {
                Text(text = "Update")
            }
            Spacer(modifier = Modifier.height(30.dp))
            Icon(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .clickable {
                        viewModel.deleteNote(data!!, context)
                        navController.popBackStack()
                    },
                imageVector = Icons.Default.Delete, contentDescription = "Delete"
            )

        }

    }

}


fun updateData(
    context: Context,
    upData: String,
    upTitle: String,
    id: Int,
    viewModel: MainViewModel
) {

    val upData = NoteEntity(upTitle, upData, id)
    viewModel.updateData(upData, context)

}
