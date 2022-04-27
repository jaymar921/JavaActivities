package com.jaymar921.CustomEvent.CALLER;

import com.jaymar921.CustomEvent.Event.CustomEvent;
import com.jaymar921.CustomEvent.Event.Listener;
import com.jaymar921.CustomEvent.EventClasses.PlayerDamageEvent;
import org.jetbrains.annotations.NotNull;


// this class is always called
public class AnotherEventCaller implements Listener {

    @CustomEvent
    public void listen(@NotNull PlayerDamageEvent event){

        if(event.getPlayer().getName().equals("Jay") && event.getHealth() > 0) {
            System.out.println("Damage player with name 'Jay' by 70 if health is greater than 0");
            event.damage(70);
        }

    }
}
