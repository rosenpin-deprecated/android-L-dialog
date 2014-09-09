package example.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import rosenpin.androidL.dialog.AndroidLDialog;


/**
 * Created by tomer on 09/09/14.
 */
public class Test extends Activity {
    AndroidLDialog androidLDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example);
        androidLDialog = new AndroidLDialog.Builder(Test.this)
                //settings title
                .Title("Dialog Title!")
                //settings message
                .Message("Hi there! You are successfully using my library, android l dialog. \n My name is Tomer Rosenfeld I'm a 15 year old israeli kid who loves android, right now i'm typing stuff so you can see how a long message looks like in the dialog, try pressing the OK button to see the sexy animation.")
                //adding positive (right) button
                .setPositiveButton("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                //adding negative (center) button
                .setNegativeButton("CANCEL", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        androidLDialog.hide();
                    }
                })
                //showing the dialog!
                .show();

                //optional.. setting icon but it's not very android l like
               //androidLDialog.setIcon(R.drawable.ic_launcher);
        /**
         * Try out functions like
         *         androidLDialog.getTitle();
         *         androidLDialog.setMessageTextSize(CUSTOM_SIZE);
         *         androidLDialog.setTitleTextSize(CUSTOM_SIZE);
         *         androidLDialog.getMessage();
         *         androidLDialog.setMessageColor(android.R.color.black);
         *         androidLDialog.setTitleColor(android.R.color.black);
         *         androidLDialog.setBackground(R.drawable.someBackground);
         *
         *         SEE ALL FEATURES OF THIS LIBRARY IN THE README
         */
    }
}
