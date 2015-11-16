package com.XOProject.controllers;

import com.XOProject.model.Figure;

import java.awt.*;
import com.XOProject.model.Field;
import com.XOProject.model.exception.AllreadyOcupaitedException;
import com.XOProject.model.exception.InvalidPointException;

/**
 * Created by vlad on 16.11.15.
 */
public class MoveController {

    public void applyFigure( final Field  field,
                             final Point  point,
                             final Figure figure) throws InvalidPointException,
                                                         AllreadyOcupaitedException {
        if(field.getFigure(point) != null){
            throw new AllreadyOcupaitedException();
        }
        field.setFigure(point,figure);
    }
}
