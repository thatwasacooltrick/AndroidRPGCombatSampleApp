package com.zestymouse.SimpleCombatFramework;

import android.app.Activity;
import android.view.View;
import android.widget.ScrollView;
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

    public String[] getInput() {
        return input;
    }

    public void setInput(String[] input) {
        this.input = input;
    }

    String[] input;
    boolean isRendering;
    TextView textView;
    String text;
    Activity activity;
    ScrollView buttons;

    public TextRenderer(Activity activity, String[] input, TextView textView, ScrollView buttons){
        this.setInput(input);
        this.setActivity(activity);
        this.setTextView(textView);
        this.buttons = buttons;
        isRendering = false;
    }

    @Override
    public void run() {
        super.run();

        //hide the Interaction Buttons
        hideScrollView(buttons);
        isRendering = true;
        String output;
        for(int o = 0; o < input.length; o++) {
            text = input[o];
            for (int i = 0; i <= text.length(); i++) {
                output = text.substring(0, i);
                updateTextBox(output, textView);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isRendering = false;
            showScrollView(buttons);
        }
    }

    public void updateTextBox(String msg, TextView textView) {
        String str = msg;
        activity.runOnUiThread(() -> textView.setText(str));
    }

    public void hideScrollView(ScrollView v) {
        activity.runOnUiThread(() -> v.setVisibility(View.GONE));
    }

    public void showScrollView(ScrollView v) {
        activity.runOnUiThread(() -> v.setVisibility(View.VISIBLE));
    }
}
