#Commands for Android Databinding

With Databinding it is possible to build Android apps with MVVM in a way that is similar to WPF. So it naturally makes sense to look at practices and patterns from that platform and see if they work in Android development.

One of the basic features of WPF are [Commands](https://msdn.microsoft.com/en-us/library/ms752308(v=vs.110).aspx).
This library is an implementation of that pattern for Android.

#What are Commands and what are they good for?

Commands have two functions.

1. They can be executed.
2. They can tell if they can be executed.

Commands are mainly used when a user has to interact with the UI and the ViewModel has to react to that. For that a Command is bound to a certain type of event of a UI element.

Example:

A Command is bound to the "Click" event of a button. This has the following consequences:

- When the button is clicked the Command is executed.
- The button is only enabled if the Command can be executed.

# I want to see code!

Sure, let's go.

The first step is to create a Command in your ViewModel. Since [Command](https://github.com/trbnb/DatabindingCommands/blob/master/library/src/main/java/de/trbnb/databindingcommands/command/Command.java) is only an interface you have to choose which implementation you want to use. This library includes two from the start:
  - [SimpleCommand](https://github.com/trbnb/DatabindingCommands/blob/master/library/src/main/java/de/trbnb/databindingcommands/command/SimpleCommand.java)
  - [MutableSimpleCommand](https://github.com/trbnb/DatabindingCommands/blob/master/library/src/main/java/de/trbnb/databindingcommands/command/MutableSimpleCommand.java)

SimpleCommand lets you pass a Runnable in the constructor. This Runnable instance will then be run when the Command is executed.

MutableSimpleCommand goes a step further and lets you change the Runnable later on if you want to.

Both have an extra constructor which lets you set the enabled-state from the start.

A sample could look like this:

```java
private Command buttonCommand = new SimpleCommand(new Runnable() {
    @Override
    public void run() {
        Toast.makeText(context, "It just works!", Toast.LENGTH_LONG).show();
    }
}, false);
```

After the Command is present in your ViewModel you can now bind it to any View with the `android:clickCommand` attribute. Your code could then look like this:

```xml
<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Sample Button"
    android:clickCommand="@{vm.buttonCommand}"/>
```

A Command that is bound via this attribute will be executed on click events. The enabled-state of the Command is also bound to enabled-state of the View. At the moment there is only support for "onClick"-event.

# Import as dependency

You can use this library by using [JitPack](https://jitpack.io/) by adding the following lines to your Gradle build script.

```gradle
repositories {
    ...
    maven { url 'https://jitpack.io' }
}

dependencies {
    ...
    compile 'com.github.trbnb:DatabindingCommands:-SNAPSHOT'
}
```