package com.jaymar921.CustomEvent.CALLER;

import com.jaymar921.CustomEvent.Event.CustomEvent;
import com.jaymar921.CustomEvent.Event.Listener;
import com.jaymar921.CustomEvent.EventClasses.PlayerDamageEvent;
import org.jetbrains.annotations.NotNull;


// this class is always called
public class EventCaller implements Listener {

    @CustomEvent
    private void checkPlayer(@NotNull PlayerDamageEvent event){
        System.out.println("Show player info event");
        System.out.println("Player ["+event.getPlayer().getName()+" - HP: "+event.getHealth()+"]");
    }
}
