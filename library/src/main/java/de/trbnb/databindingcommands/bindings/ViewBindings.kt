package de.trbnb.databindingcommands.bindings

import android.databinding.BindingAdapter
import android.view.View
import de.trbnb.databindingcommands.command.Command

@BindingAdapter("android:clickCommand")
fun View.bindClickCommand(command: Command<*>) {
    bindEnabled(command)

    setOnClickListener {
        command.invokeSafely()
    }
}

private fun View.bindEnabled(command: Command<*>) {
    isEnabled = command.isEnabled

    command.addEnabledListener {
        post {
            isEnabled = it
        }
    }
}

@BindingAdapter("android:longClickCommand")
fun View.bindLongClickCommand(command: Command<*>) {
    setOnLongClickListener {
        if (command.isEnabled) {
            command.invokeSafely() as? Boolean ?: true
        } else {
            false
        }
    }
}
