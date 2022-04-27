package com.jaymar921.CustomEvent.EventClasses;


import com.jaymar921.CustomEvent.Event.Event;
import com.jaymar921.CustomEvent.Event.Player;

public class PlayerDamageEvent extends Event {

    public PlayerDamageEvent(Player player){
        super(player);
    }

    public void damage(int damage) {
        getPlayer().setHealth(Math.max(getPlayer().getHealth()-damage,0));
    }

    public int getHealth() {
        return getPlayer().getHealth();
    }


    public void setHealth(int health) {
        getPlayer().setHealth(health);
    }

}
