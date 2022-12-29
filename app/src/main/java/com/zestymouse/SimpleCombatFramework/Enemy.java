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

    public Enemy(Drawable icon, String name, String[] dialogue){
        setDialogue(dialogue);
        setName(name);
        setIcon(icon);
    }
}
