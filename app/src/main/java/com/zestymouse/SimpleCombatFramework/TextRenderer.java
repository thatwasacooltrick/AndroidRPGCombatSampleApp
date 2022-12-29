package com.zestymouse.SimpleCombatFramework;

import android.app.Activity;
import android.widget.TextView;

public class TextRenderer extends Thread{

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    boolean isRendering;
    TextView textView;
    String text;
    Activity activity;

    public TextRenderer(Activity activity, String text, TextView textView){
        this.setText(text);
        this.setActivity(activity);
        this.setTextView(textView);
        isRendering = false;
    }

    @Override
    public void run() {
        super.run();
        isRendering = true;
        String output;

        for(int i = 0; i <= text.length(); i++){
            output = text.substring(0, i);
            updateTextBox(output, textView);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        isRendering = false;

    }

    public void updateTextBox(String msg, TextView textView) {
        String str = msg;
        activity.runOnUiThread(() -> textView.setText(str));
    }
}
