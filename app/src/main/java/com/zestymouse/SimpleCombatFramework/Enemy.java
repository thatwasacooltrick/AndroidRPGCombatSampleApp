package com.zestymouse.SimpleCombatFramework;

import android.graphics.drawable.Drawable;

public class Enemy extends Player {


    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getDialogue() {
        return dialogue;
    }

    public void setDialogue(String[] dialogue) {
        this.dialogue = dialogue;
    }


    Drawable icon;
    String name;
    String dialogue[];
    String defaultMessage;
    String attackMessage;
    TextRenderer t;

    public Enemy(Drawable icon, String name){
        setHp(10);
        setAtk(4);
        setName(name);
        setIcon(icon);
        defaultMessage = name + " is standing menacingly";
        attackMessage= name + " Attacks!";
    }

    @Override
    public int playerAttack(){
        int seed = (int) (Math.random() * 100);
        if (seed > 25){
            lastHit = true;
            setTurnText(name +" Hits!");
            return atk;
        }else{
            lastHit = false;
            setTurnText(name + " Missed");
            return 0;
        }
    }


}
