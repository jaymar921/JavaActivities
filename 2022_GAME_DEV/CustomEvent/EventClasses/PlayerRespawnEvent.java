package com.jaymar921.CustomEvent.EventClasses;

import com.jaymar921.CustomEvent.Event.Event;
import com.jaymar921.CustomEvent.Event.Player;

public class PlayerRespawnEvent extends Event {

    public PlayerRespawnEvent(Player player){
        super(player);
        getPlayer().setHealth(100);
        System.out.println(player.getName()+" respawned");
    }

}
