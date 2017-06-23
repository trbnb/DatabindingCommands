package de.trbnb.databindingcommandsapp

import android.content.Context
import android.databinding.BaseObservable
import android.widget.Toast
import de.trbnb.databindingcommands.command.SimpleCommand

class MainViewModel : BaseObservable() {

    val buttonCommand = SimpleCommand { it: Context ->
        Toast.makeText(it, "It just works!", Toast.LENGTH_LONG).show()
    }

    val longClickCommand = SimpleCommand { it: Context ->
        Toast.makeText(it, "This is long click!", Toast.LENGTH_LONG).show()
        true
    }
}
