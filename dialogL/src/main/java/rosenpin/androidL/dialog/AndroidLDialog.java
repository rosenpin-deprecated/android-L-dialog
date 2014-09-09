package rosenpin.androidL.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by tomer on 09/09/14.
 */
public class AndroidLDialog extends Dialog {
    public AndroidLDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog);

    }
    public void setBackground(int resource){
        RelativeLayout back = (RelativeLayout)findViewById(R.id.background);
        back.setBackgroundResource(resource);
    }
    public void setBackground(Drawable image){
        RelativeLayout back = (RelativeLayout)findViewById(R.id.background);
        back.setBackgroundDrawable(image);
    }
    public void setBackgroundColor(int color){
        RelativeLayout back = (RelativeLayout)findViewById(R.id.background);
        back.setBackgroundColor(color);
    }

    public void setTitle(String title){
        TextView tv = (TextView)findViewById(android.R.id.text1);
        tv.setText(title);
    }
    /*
    Setting icon... not in actual android l dialogs but in case you wanna use it..
    */
    public void setIcon(int Resource){
        ImageView img = (ImageView)findViewById(R.id.image);
        img.setBackgroundResource(Resource);
    }
    public void setIcon(Drawable icon){
        ImageView img = (ImageView)findViewById(R.id.image);
        img.setImageDrawable(icon);
    }
    public void setTitleColor(int Color){
        TextView tv = (TextView)findViewById(android.R.id.text1);
        tv.setTextColor(Color);
    }
    public void setMessageColor(int Color){
        TextView tv = (TextView)findViewById(android.R.id.text2);
        tv.setTextColor(Color);
    }
    public String getTitle(){
        TextView tv = (TextView)findViewById(android.R.id.text1);
        return tv.getText().toString();
    }
    public String getMessage(){
        TextView tv = (TextView)findViewById(android.R.id.text2);
        return tv.getText().toString();
    }
    public void setTitleTextSize(int size){
        TextView tv = (TextView)findViewById(android.R.id.text1);
        tv.setTextSize(size);
    }
    public void setMessageTextSize(int size){
        TextView tv = (TextView)findViewById(android.R.id.text2);
        tv.setTextSize(size);
    }
    public void setMessage(String message){
        TextView tv = (TextView)findViewById(android.R.id.text2);
        tv.setText(message);
    }
    public void setPositiveButton(String text,View.OnClickListener onClickListener){
        Button tv = (Button)findViewById(android.R.id.button1);
        tv.setText(text);
        tv.setOnClickListener(onClickListener);
    }
    public void setNegativeButton(String text,View.OnClickListener onClickListener){
        Button tv = (Button)findViewById(android.R.id.button2);
        tv.setText(text);
        tv.setOnClickListener(onClickListener);
    }
    static public class Builder {
        AndroidLDialog androidLDialog;
        public Builder(Context context) {
            this.context = context;
            androidLDialog = new AndroidLDialog(this.context);
        }
        private String title,message,buttonText1,buttonText2;
        private Drawable icon;
        private int logo = 0;
        private View.OnClickListener onClickListener1,onClickListener2;
        private Context context;
        public Builder Title(String Title){
            this.title = Title;
            return this;
        }
        public Builder Message(String Message){
            this.message = Message;
            return this;
        }
        public Builder setPositiveButton(String buttonText,View.OnClickListener onClickListener){
            this.buttonText1 = buttonText;
            this.onClickListener1 = onClickListener;
            return this;
        }
        public Builder setNegativeButton(String buttonText,View.OnClickListener onClickListener){
            this.buttonText2 = buttonText;
            this.onClickListener2 = onClickListener;
            return this;
        }

        /*
        Setting icon... not in actual android l dialogs but in case you wanna use it..
        */
        public Builder setIcon(int Resource){
            this.logo = Resource;
            return this;
        }
        public Builder setIcon(Drawable drawable){
            this.icon = drawable;
            return this;
        }
        public AndroidLDialog show(){
            androidLDialog.setTitle(this.title);
            androidLDialog.setMessage(this.message);
            androidLDialog.setPositiveButton(this.buttonText1,onClickListener1);
            androidLDialog.setNegativeButton(this.buttonText2,onClickListener2);
            /*
            Setting icon... not in actual android l dialogs but in case you wanna use it..
            */
            if(logo != 0){
                androidLDialog.setIcon(logo);}
            else{
                androidLDialog.setIcon(icon);}
            androidLDialog.show();
            return androidLDialog;
        }
        public AndroidLDialog hide(){
            androidLDialog.hide();
            return androidLDialog;
        }
    }
}
