Android L Dialog
==============

A library to be used for creating android-l like dialogs on android 2.3+

![alt tag](http://i.picresize.com/images/2014/09/09/gSHu9.png)


Hi, my name is Tomer Rosenfeld.
I'm a 15 years old Israeli kid, I love android and especially android L so I figured, why not make android developer's life easier?
So here you go.
A simple to use library to create a android L dialog on any 2.3+ android device in your app using 3 Lines of code! 

How to compile the example
==========================
1. Download the zip

2. Extract

3. Import with android studio or intellij

4. Run


How to use the library in your project
======================================

1. Download the zip or clone the rpository

2. Pull the dialogL folder from the example project to your project root directory

3. Add the library project as a dependency in your build.gradle file like shown below

4. Gradle sync and rebuild project

5. Add AndroidLDialog to your code!, see "Instructions"

```groovy
dependencies {
    compile project(':dialogL')
}
```

Instructions
=============


BASICS
------

Creating the basic dialog:
```java
AndroidLDialog dialog = new AndroidLDialog.Builder(ActivityName.this)
    .Title("A Title)
    .Message("A message)
    .setPositiveButton("TEXT" , new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
    .setNegativeButton("CANCEL", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
      //finally
      .show();
```

More? OK!
=========

ADVANCED
--------

Changing the dialog background:
```java
dialog.setBackground(R.drawable.background);
//or
dialog.setBackground(Your Drawable);
//or
dialog.setBackgroundColor(R.color.your_color);
```

Getting text from the dialog
-----------------------------

```java
String title = dialog.getTitle();
//or
String message = dialog.getMessage();
```

More customization
------------------

```java
dialog.setTitleColor(getResources().getColor(R.color.your_color);
//or
dialog.setMessageColor(getResources().getColor(R.color.your_color);
//or
dialog.setTitleTextSize(22);
//or
dialog.setMessageTextSize(22);
```


Adding stuff from 'Dialog' default constractor
-------------------------------------
After defining the AndroidLDialog.Builder

```
    AndroidLDialog androidLDialog = new AndroidLDialog.Builder(Test.this)
        .setTitle("Title");
        .setMessage("Message")
        .show();
```

Add the stuff you want like
```
    androidLDialog.setCancelable(false);
```
etc.

Please notice:
If you are using android 3.0- you won't get the onclick animation.

Q&A
====

Ask me on facebook here https://www.facebook.com/rosenpin4ever
