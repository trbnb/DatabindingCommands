package de.trbnb.databindingcommands.bindings;

import android.databinding.BindingAdapter;
import android.view.View;

import de.trbnb.databindingcommands.command.Command;
import de.trbnb.databindingcommands.command.EnabledChangedListener;

public class ViewBindings {

    // no instance
    private ViewBindings(){}

    @BindingAdapter({"android:clickCommand"})
    public static void bindCommand(final View view, final Command command){
        view.setEnabled(command.isEnabled());

        command.setEnabledChangedListener(new EnabledChangedListener() {
            @Override
            public void onEnabledChanged(boolean enabled) {
                view.setEnabled(enabled);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                command.execute();
            }
        });
    }
}
