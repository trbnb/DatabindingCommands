package de.trbnb.databindingcommandsapp;

import android.content.Context;
import android.databinding.BaseObservable;
import android.widget.Toast;

import de.trbnb.databindingcommands.command.SimpleCommand;
import de.trbnb.databindingcommands.functions.Action;

public class MainViewModel extends BaseObservable {

    private SimpleCommand buttonCommand = new SimpleCommand(new Action<Context>() {
        @Override
        public void invoke(Context context) {
            Toast.makeText(context, "It just works!", Toast.LENGTH_LONG).show();
        }
    }, false);

    public SimpleCommand getButtonCommand() {
        return buttonCommand;
    }
}
