package com.XOProject.controllers;

import com.XOProject.model.Field;
import com.XOProject.model.Figure;
import com.XOProject.model.exception.InvalidPointException;
import com.XOProject.model.exception.XOException;

import java.awt.*;

/**
 * Created by vlad on 17.11.15.
 */
public class WinnerController {

    public Figure getWinner(final Field field) {
        try{
            for (int i=0; i < 3 ; i++)
                if(check(field, new Point(1,0), p -> new Point(p.x, p.y + 1)))
                    return field.getFigure(new Point(1,0));
            for (int i=0; i < 3 ; i++)
                if(check(field, new Point(0,1), p -> new Point(p.x + 1, p.y)))
                    return field.getFigure(new Point(0,1));
            for (int i=0; i < 3 ; i++)
                if(check(field, new Point(1,0), p -> new Point(p.x + 1, p.y + 1)))
                    return field.getFigure(new Point(1,0));
            for (int i=0; i < 3 ; i++)
                if(check(field, new Point(0,2), p -> new Point(p.x - 1, p.y + 1)))
                    return field.getFigure(new Point(0,2));

        } catch (XOException e){}

        return null;
    }

    private boolean check(final Field field,
                          final Point currentPoint,
                          final IPointGenerator pointGenerator
                          ){
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try{
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);
            } catch (InvalidPointException e) {
            return true;
        }

        if(currentFigure == null) return false;

        if(currentFigure != nextFigure) return false;

         return  check(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {
        public Point next (final Point point);
    }

}
