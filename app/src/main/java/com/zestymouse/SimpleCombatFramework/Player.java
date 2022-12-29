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
    boolean lastHit;

    public String getTurnText() {
        return turnText;
    }

    public void setTurnText(String turnText) {
        this.turnText = turnText;
    }

    String turnText;

    public Player(){
        setTurnText("");
        setAtk(5);
        setHp(100);


    }

    public void physicalAttack(Enemy enemy){
        enemy.setHp(enemy.getHp() - atk);
    }

    int playerAttack(){
        int seed = (int) (Math.random() * 100);
        if (seed > 25){
            lastHit = true;
            setTurnText("You Hit!");
            return atk;
        }else{
            lastHit = false;
            setTurnText("You Miss");
            return 0;
        }
    }
}
