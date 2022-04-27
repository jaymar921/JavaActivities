package com.jaymar921.CustomEvent;

import com.jaymar921.CustomEvent.Event.*;
import com.jaymar921.CustomEvent.EventClasses.PlayerDamageEvent;
import com.jaymar921.CustomEvent.EventClasses.PlayerDeathEvent;
import com.jaymar921.CustomEvent.EventClasses.PlayerRespawnEvent;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class SimpleGame {

    // stores the players in a list
    private final List<Player> players;

    // allows the threading to continue looping
    public static boolean run;
    public static int count = 0;

    // load the event handler class
    EventHandler eventHandler;


    // constructor, basically initializes the classes and starts the threading
    public SimpleGame(){
        players = new ArrayList<>();
        run = true;
        eventHandler = new EventHandler();
        threading();
    }

    // get the online players (who joined)
    public List<Player> getOnlinePlayers(){
        return players;
    }

    // add the new player who joins into the players list
    public void joinPlayer(Player player){
        System.out.println(player.getName() + " has joined with "+player.getHealth()+" Health");
        getOnlinePlayers().add(player);
    }

    // remove the player who are in game into the players list
    public void quitPlayer(Player player){
        System.out.println(player.getName() + " has left with "+player.getHealth()+" Health");
        getOnlinePlayers().remove(player);
    }

    // get the event handler class, which is responsible for registering outside classes
    public EventHandler getEventHandler(){return eventHandler;}


    // starts the game
    public void threading(){

        Thread thread = new Thread(() -> {

            while (SimpleGame.run) {
                // just a counter that will stop the game if count > 4
                if(SimpleGame.count++ > 4) {
                    SimpleGame.run = false;
                }
                try {

                    // checks for online players and iterate them all one by one
                    for(Player player : getOnlinePlayers()){

                        // get the registered classes that associates with the Event.class
                        eventHandler.REGISTERED_EVENTS.forEach((k, v)->{
                            try {
                                // loop for each value(Method) set
                                v.forEach(x->{
                                    try {
                                        // invoke the class instance and the damage event
                                        if(x.getParameterTypes()[0].isAssignableFrom(PlayerDamageEvent.class)) {
                                            x.invoke(eventHandler.REGISTERED_CLASSES.get(x.getDeclaringClass().getName()), new PlayerDamageEvent(player));
                                        }
                                        // invoke the class instance and the death event if player health is 0
                                        if(x.getParameterTypes()[0].isAssignableFrom(PlayerDeathEvent.class) && player.getHealth()==0) {
                                            x.invoke(eventHandler.REGISTERED_CLASSES.get(x.getDeclaringClass().getName()), new PlayerDeathEvent(player));
                                        }
                                        // invoke the class instance and the respawn event if player health is 0
                                        if(x.getParameterTypes()[0].isAssignableFrom(PlayerRespawnEvent.class) && player.getHealth()==0) {
                                            x.invoke(eventHandler.REGISTERED_CLASSES.get(x.getDeclaringClass().getName()), new PlayerRespawnEvent(player));
                                        }
                                    } catch (IllegalAccessException | InvocationTargetException e) {
                                        e.printStackTrace();
                                    }
                                });
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        });
                    }

                }catch (Exception e){e.printStackTrace();}
                try {
                    // sleep for 1s to show the output slowly
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

}
