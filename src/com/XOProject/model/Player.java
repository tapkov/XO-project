package com.XOProject.model;

/**
 * Created by vlad on 11.11.15.
 */
public class Player {

    public final String namePlayer  ;

    public final Figure playersFigure ;

    public Player(String namePlayer, Figure playersFigure) {
        this.namePlayer = namePlayer;

        this.playersFigure = playersFigure;
    }

    public String getName(){
        return namePlayer;
}

    public Figure getFigure() {
        return playersFigure;
    }
}
