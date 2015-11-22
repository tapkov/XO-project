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

    Figure currentMove (final Field field) throws InvalidPointException {
        //We can use not 2For, and class with for
        for (int j = 0; j < field.getSize_field(); j++) {
            for (int i = 0; i < field.getSize_field(); i++) {
                //We can use as IfElse , as Switch
                if (field.getFigure(new Point(i, j)) == Figure.X)
                    counterX++;
                if (field.getFigure(new Point(i, j)) == Figure.O)
                    counterO++;
            }
        }

        //There we can simple count amount Figure, and if amount
        // will be even(figure%2 = 0) number, next move on X.

        if (counterX+counterO == field.getSize_field()*field.getSize_field()){
            return null;
        } else {
            if (counterO < counterX) {
                return Figure.O;
            } else {return Figure.X;}
        }
    }
}
