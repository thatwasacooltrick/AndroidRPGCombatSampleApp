package com.zestymouse.SimpleCombatFramework;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView t;
    TextView hpBox;
    TextRenderer textRenderer;
    ImageView enemyImage;
    ArrayList<String> TextManager;
    Player player;
    Enemy enemy;
    String[] defaultText;
    ScrollView buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //declare the player and enemy
        Drawable d = getDrawable(R.drawable.placeholder);
        player = new Player();
        enemy = new Enemy(d, "Kyle");



        //find the views
        buttons = findViewById(R.id.buttonControls);
        enemyImage = findViewById(R.id.enemyImage);
        defaultText = new String[]{"You've met with a terrible fate, haven't you"};
        hpBox = findViewById(R.id.hpView);
        hpBox.setText(String.valueOf(player.getHp()));

        //Add the flashy background animation
        backgroundAnimation();

        t = findViewById(R.id.messageView);
        textRenderer = new TextRenderer(this, defaultText, t, buttons);


    }


    public void fight(View v){
        if(!textRenderer.isRendering) {
            enemy.setHp(enemy.getHp() - player.playerAttack());
            player.setHp(player.getHp() - enemy.playerAttack());
            String[] render = new String[]{enemy.getTurnText(), player.getTurnText()};
            hpBox.setText(String.valueOf(player.getHp()));
            textRenderer = new TextRenderer(this, render, t, buttons);
            textRenderer.start();
            if(player.lastHit) {
                scaleView(enemyImage);
            }

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


    public void backgroundAnimation(){
        ConstraintLayout constraintLayout = findViewById(R.id.mainLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();

    }



    public void checkBattleStatus(){
        if(player.getHp() < 0 || enemy.getHp() < 0){
            TextView vic = findViewById(R.id.VictoryMessage);
            vic.setVisibility(View.VISIBLE);
        }
    }


    public void enemyAttack(){

    }



}


