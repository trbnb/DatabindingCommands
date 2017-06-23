package de.trbnb.databindingcommands

import android.databinding.Observable

inline fun Observable.addPropertyChangedCallback(crossinline callback: (Observable, Int) -> Unit){
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable, propertyId: Int) {
            callback(sender, propertyId)
        }
    })
}