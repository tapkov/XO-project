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

        for (int j = 0; j < field.getSize_field(); j++) {
            for (int i = 0; i < field.getSize_field(); i++) {
                if (field.getFigure(new Point(i, j)) == Figure.X)
                    counterX++;
                if (field.getFigure(new Point(i, j)) == Figure.O)
                    counterO++;
            }
        }

        if (counterO < counterX)
            return Figure.O;
        else return Figure.X;

    }
}
