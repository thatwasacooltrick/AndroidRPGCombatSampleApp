package com.zestymouse.SimpleCombatFramework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView t;
    TextRenderer textRenderer;
    ImageView enemyImage;
    ArrayList<String> TextManager;
    Player p;
    Enemy[] enemies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enemyImage = findViewById(R.id.enemyImage);

        ConstraintLayout constraintLayout = findViewById(R.id.mainLayout);


        //Add the flashy background animation
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();
        t = findViewById(R.id.messageView);
        textRenderer = new TextRenderer(this, "You've met with a terrible fate, haven't you", t);


    }


    public void changeText(View v){
        if(!textRenderer.isRendering) {
            textRenderer = new TextRenderer(this, "You've met with a terrible fate, haven't you", t);
            textRenderer.start();
            scaleView(enemyImage);

        }
    }


    public void scaleView(View v) {
        Animation anim = new ScaleAnimation(
                0.9f, 1f, // Start and end values for the X axis scaling
                0.9f, 1f, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(1000);
        v.startAnimation(anim);
    }



}


