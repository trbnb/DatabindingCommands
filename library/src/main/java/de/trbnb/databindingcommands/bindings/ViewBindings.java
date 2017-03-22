package de.trbnb.databindingcommands.bindings;

import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.view.View;

import de.trbnb.databindingcommands.BR;
import de.trbnb.databindingcommands.command.Command;

public class ViewBindings {

    // no instance
    private ViewBindings(){}

    @BindingAdapter({"android:clickCommand"})
    public static void bindCommand(final View view, final Command command){
        view.setEnabled(command.isEnabled());

        command.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int propertyId) {
                if(propertyId == BR.enabled){
                    view.setEnabled(command.isEnabled());
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                command.execute(v.getContext());
            }
        });
    }
}
