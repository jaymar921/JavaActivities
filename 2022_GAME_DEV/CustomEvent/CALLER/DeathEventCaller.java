package com.jaymar921.CustomEvent.CALLER;

import com.jaymar921.CustomEvent.Event.CustomEvent;
import com.jaymar921.CustomEvent.Event.Listener;
import com.jaymar921.CustomEvent.EventClasses.PlayerDeathEvent;

// whenever the player dies, this class is being called
public class DeathEventCaller implements Listener {

    @CustomEvent
    private void onPlayerDeath(PlayerDeathEvent event){
        System.out.println("----DEATH ANNOUNCEMENT---");
        System.out.println(event.getDeathMessage());
        System.out.println("-------------------------");
    }
}
