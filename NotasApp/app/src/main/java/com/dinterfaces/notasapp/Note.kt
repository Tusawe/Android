package com.dinterfaces.notasapp

import java.util.*

data class Note(var titulo:String, var body:String, var date:Date) {

    override fun toString(): String = titulo

}