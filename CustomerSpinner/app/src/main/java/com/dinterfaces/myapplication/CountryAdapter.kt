package com.dinterfaces.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.SpinnerAdapter
import android.widget.TextView

class CountryAdapter (val context : Context, val countries : List<Country>) : BaseAdapter(), SpinnerAdapter {

    override fun getCount() = countries.size

    override fun getItem(p0: Int) = countries[p0]

    override fun getItemId(p0: Int) = p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val view = LayoutInflater.from(context).inflate(R.layout.spinner_view_layout, p2, false)
        val country = countries[p0]

        view.findViewById<ImageView>(R.id.countryFlag).setImageResource(country.flag)
        view.findViewById<TextView>(R.id.countryName).text = country.name

        return view

    }

    override fun getDropDownView(p0: Int, p1: View?, p2: ViewGroup?): View {

        return getView(p0, p1, p2)

    }

}