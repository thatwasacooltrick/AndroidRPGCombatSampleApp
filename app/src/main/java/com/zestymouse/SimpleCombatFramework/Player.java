package com.zestymouse.SimpleCombatFramework;

public class Player {

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    int hp;
    int lv;
    int atk;

    public Player(){

    }

    public void physicalAttack(Enemy enemy){
        enemy.setHp(enemy.getHp() - atk);
    }
}
