package com.XOProject.controllers;

import com.XOProject.model.Field;
import com.XOProject.model.Figure;
import com.XOProject.model.exception.InvalidPointException;

import java.awt.*;

/**
 * Created by vlad on 22.11.15.
 */
public class CurrentMoveController {

    private int counterX = 0;
    private int counterO = 0;

    // In rules to game XO, X have first move.

    public Figure currentMove (final Field field) throws InvalidPointException {
        //We can use not 2For, and class with for
        counterO=0;
        counterX=0;
        for (int j = 0; j < field.getSize_field(); j++) {
            for (int i = 0; i < field.getSize_field(); i++) {
                //We can use as IfElse , as Switch
                if (field.getFigure(new Point(i, j)) == Figure.X)
                    counterX++;
                if (field.getFigure(new Point(i, j)) == Figure.O)
                    counterO++;
            }
        }

        if (counterX+counterO == field.getSize_field()*field.getSize_field()){
            return null;
        } else {
            if ((counterO+counterX)%2 == 0) {
                return Figure.X;
            } else {return Figure.O;}
        }
    }
}
