package de.trbnb.databindingcommandsapp

import android.content.Context
import android.databinding.BaseObservable
import android.widget.Toast
import de.trbnb.databindingcommands.command.SimpleCommand

class MainViewModel(private val appContext: Context) : BaseObservable() {

    val buttonCommand = SimpleCommand {
        Toast.makeText(appContext, "It just works!", Toast.LENGTH_LONG).show()
    }

    val longClickCommand = SimpleCommand {
        Toast.makeText(appContext, "This is long click!", Toast.LENGTH_LONG).show()
        true
    }
}
