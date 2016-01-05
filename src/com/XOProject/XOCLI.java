package com.XOProject;

import com.XOProject.model.Field;
import com.XOProject.model.Figure;
import com.XOProject.model.Game;
import com.XOProject.model.Player;
import com.XOProject.model.exception.InvalidPointException;
import com.XOProject.view.ConsoleView;

/**
 * Created by vlad on 03.01.16.
 */
public class XOCLI {

    public static void main(String[] args) throws InvalidPointException {

        String name1 = "1";
        String name2 = "2";

        Player[] player = new Player[2];
        player[0] = new Player(name1, Figure.O);
        player[1] = new Player(name2, Figure.X);

        final Game gameXO = new Game(player, new Field(3), "XO" );

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)){
            consoleView.show(gameXO);
        }





        }
}