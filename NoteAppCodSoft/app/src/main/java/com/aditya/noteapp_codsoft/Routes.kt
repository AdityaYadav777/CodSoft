package com.aditya.noteapp_codsoft

 sealed class Routes(val routes: String){

  object Home :Routes("Home")
  object Create:Routes("Create")
  object UpdateScreen:Routes("UpdateScreen")

}