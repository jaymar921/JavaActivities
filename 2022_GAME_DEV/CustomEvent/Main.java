package com.jaymar921.CustomEvent;

import CALLER.AnotherEventCaller;
import CALLER.DeathEventCaller;
import CALLER.EventCaller;
import CALLER.RespawnEventCaller;
import Event.Player;

public class Main {

    public static void main(String[] args) {

        // create the game instance
        SimpleGame game = new SimpleGame();

        // create the players
        Player jay = new Player("Jay");
        Player pia = new Player("Pia");

        // join the players
        game.joinPlayer(jay);
        game.joinPlayer(pia);

        // load the event listeners
        game.getEventHandler().registerEvent(new EventCaller());
        game.getEventHandler().registerEvent(new AnotherEventCaller());
        game.getEventHandler().registerEvent(new DeathEventCaller());
        game.getEventHandler().registerEvent(new RespawnEventCaller());

        try{
            // sleep for 8s before player 'jay' quit
            Thread.sleep(8000);
            game.quitPlayer(jay);
        }catch (Exception ignore){}
    }
}
