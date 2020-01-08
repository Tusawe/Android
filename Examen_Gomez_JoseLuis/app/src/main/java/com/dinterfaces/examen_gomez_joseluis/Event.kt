package com.dinterfaces.examen_gomez_joseluis

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event (var name : String,
                var place : String,
                var datetime : String,
                var description : String,
                var speaker : String) : Parcelable