package com.aditya.noteapp_codsoft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aditya.noteapp_codsoft.MVVM.MainViewModel
import com.aditya.noteapp_codsoft.Screens.CreateNote
import com.aditya.noteapp_codsoft.Screens.Home
import com.aditya.noteapp_codsoft.Screens.UpdateScreen
import com.aditya.noteapp_codsoft.ui.theme.NoteAppCodSoftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel=ViewModelProvider(this)[MainViewModel::class]
            NoteAppCodSoftTheme {


                val navController= rememberNavController()
                NavHost(navController, startDestination =Routes.Home.routes ) {
                    composable(Routes.Home.routes){
                      Home(viewModel,navController)
                    }
                    composable(Routes.Create.routes){
                        CreateNote(viewModel,navController)
                    }
                    composable(Routes.UpdateScreen.routes){
                        UpdateScreen(viewModel,navController)
                    }

                }
            }
        }
    }
}

