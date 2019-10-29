package com.dinterfaces.myapplication

data class Country (val name : String, val flag : Int, val population : Int){

    override fun toString(): String {
        return name
    }

}

object CountryFactory {

    fun create() : List<Country> {

        val spain = Country("Spain", R.drawable.bandera,40000000)
        val usa = Country("USA", R.drawable.flag,120000000)
        val france = Country("France", R.drawable.bandere,30000000)
        val germany = Country("Germany", R.drawable.banderen,30000000)

        return arrayListOf<Country>(spain, usa, france, germany)

    }

}

