package com.jaymar921.CustomEvent.CALLER;

import com.jaymar921.CustomEvent.Event.CustomEvent;
import com.jaymar921.CustomEvent.Event.Listener;
import com.jaymar921.CustomEvent.EventClasses.PlayerRespawnEvent;

public class RespawnEventCaller implements Listener {

    @CustomEvent
    public void onRespawn(PlayerRespawnEvent event){
        System.out.println("Player is now alive!!!");
    }
}
