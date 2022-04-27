package com.jaymar921.CustomEvent.Event;

// player class, I think this doesn't need any explanation
public class Player {

    private int health;
    private String name;

    public Player(String name){
        this.name = name;
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
