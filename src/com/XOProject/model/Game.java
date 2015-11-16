package com.XOProject.model;

/**
 * Created by vlad on 11.11.15.
 */
public class Game {
    private Player[] players;

    private Field field;

    private String name;

    public Game (final Player[] player,
                 final Field    field,
                 final String   name
                                        ) {
        this.players = player;
        this.field   = field;
        this.name    = name;

    }

    Player[]   getPlayer() {
        return players ;
    }

    Field   getField() {
        return field;
    }

    String getName(){
        return name;
    }

}
