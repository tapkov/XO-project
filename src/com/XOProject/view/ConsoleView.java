package com.XOProject.view;

import com.XOProject.model.Field;
import com.XOProject.model.Figure;
import com.XOProject.model.Game;
import com.XOProject.model.exception.AllreadyOcupaitedException;
import com.XOProject.model.exception.InvalidPointException;
import com.XOProject.controllers.*;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by vlad on 02.01.16.
 */

public class ConsoleView {

    private CurrentMoveController currentMoveController = new CurrentMoveController();
    private WinnerController winnerController = new WinnerController();
    private MoveController moveController = new MoveController();

    public void show(final Game game) throws InvalidPointException {
        System.out.format("Game name: %s\n", game.getName());
        Field field = game.getField();
        for (int i = 0; i < field.getSize_field(); i++){
            printLine(field,i);
            if (i != (field.getSize_field()-1))
                printSeparator();
        }
    }

    public boolean move(Game game) throws InvalidPointException {
        final Field field = game.getField();
        final Figure currentFigure = currentMoveController.currentMove(field);
        final Figure winner = winnerController.getWinner(field);
        if (winner != null){
            System.out.format("Winner is : %s", winner);
            return false;
        }
        if (currentFigure == null){
            System.out.println("No winner and no move left!");
            return false;
        }
        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field,point,currentFigure);
        } catch (AllreadyOcupaitedException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint(){
        return new Point(askCoordinate("X") -1,askCoordinate("Y") -1);
    }

    private int askCoordinate (final String CoordinateName){
        System.out.format("Please input : %s", CoordinateName);
        Scanner scannerInt = new Scanner(System.in);
        try {
            return scannerInt.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Coordinate");
            return askCoordinate(CoordinateName);
        }

    }

    private void printLine(Field field,
                           int   x        )   throws InvalidPointException {
        for (int y = 0; y < field.getSize_field(); y++){
            Figure figure ;
                try {
                    figure = field.getFigure(new Point(y, x));
                } catch (InvalidPointException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            System.out.print(figure != null ? figure : " ");
            if( y != (field.getSize_field()-1))
                System.out.print(" | ");
        }
        System.out.println();
    }

    private void printSeparator(){
        System.out.println("---------");
    }

}
