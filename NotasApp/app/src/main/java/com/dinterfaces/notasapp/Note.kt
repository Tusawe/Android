package com.dinterfaces.notasapp

data class Note(var id:String, var titulo:String, var body:String, var date:String) {

    override fun toString(): String = titulo

}