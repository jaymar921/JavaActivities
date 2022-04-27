package com.jaymar921.CustomEvent.Event;

// event class
public abstract class Event {

    private final Player player;
    public Event(Player player){
        this.player = player;
    }
    public Player getPlayer(){return player;}
}
