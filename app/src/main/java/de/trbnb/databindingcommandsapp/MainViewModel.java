package de.trbnb.databindingcommandsapp;

import android.content.Context;
import android.databinding.BaseObservable;
import android.widget.Toast;

import de.trbnb.databindingcommands.command.SimpleCommand;

public class MainViewModel extends BaseObservable {

    private SimpleCommand buttonCommand = new SimpleCommand(new Runnable() {
        @Override
        public void run() {
            Toast.makeText(context, "It just works!", Toast.LENGTH_LONG).show();
        }
    }, false);

    private final Context context;

    public MainViewModel(Context context) {
        this.context = context;
    }

    public SimpleCommand getButtonCommand() {
        return buttonCommand;
    }
}
