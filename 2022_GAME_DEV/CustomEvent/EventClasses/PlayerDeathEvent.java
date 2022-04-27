package com.jaymar921.CustomEvent.EventClasses;

import com.jaymar921.CustomEvent.Event.Event;
import com.jaymar921.CustomEvent.Event.Player;

public class PlayerDeathEvent extends Event {

    private String message;
    public PlayerDeathEvent(Player player){
        super(player);
        message = player.getName() + " died";
    }

    public String getDeathMessage(){return message;}

    public void setDeathMessage(String message){this.message = message;}

}
