package de.trbnb.databindingcommands.bindings

import android.content.Context
import android.databinding.BindingAdapter
import android.view.View
import de.trbnb.databindingcommands.BR
import de.trbnb.databindingcommands.addPropertyChangedCallback
import de.trbnb.databindingcommands.command.Command

@BindingAdapter("android:clickCommand")
fun View.bindClickCommand(command: Command<Unit, *>) {
    isEnabled = command.isEnabled

    command.addPropertyChangedCallback { _, propertyId ->
        if(propertyId == BR.enabled){
            post {
                isEnabled = command.isEnabled
            }
        }
    }

    setOnClickListener {
        command.invokeSafely(Unit)
    }
}

@BindingAdapter("android:clickCommand")
fun View.bindClickCommandWithContext(command: Command<Context, *>) {
    isEnabled = command.isEnabled

    command.addPropertyChangedCallback { _, propertyId ->
        if(propertyId == BR.enabled){
            post {
                isEnabled = command.isEnabled
            }
        }
    }

    setOnClickListener {
        command.invokeSafely(context)
    }
}

@BindingAdapter("android:longClickCommand")
fun View.bindLongClickCommand(command: Command<Unit, *>){
    setOnLongClickListener {
        command.invokeSafely(Unit) as? Boolean ?: true
    }
}

@BindingAdapter("android:longClickCommand")
fun View.bindLongClickCommandWithContext(command: Command<Context, *>){
    setOnLongClickListener {
        command.invokeSafely(context) as? Boolean ?: true
    }
}