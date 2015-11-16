package com.XOProject.model;

import com.XOProject.model.exception.AllreadyOcupaitedException;
import com.XOProject.model.exception.InvalidPointException;

import java.awt.*;

/**
 * Created by vlad on 11.11.15.
 */
public class Field {

    public static final int SIZE_FIELD = 3;
    public static final int MAX_COORDINATE = SIZE_FIELD;
    public static final int MIN_COORDINATE = 0;

    Figure[][] field = new Figure[SIZE_FIELD][SIZE_FIELD];

    public int getSizeField(){
        return SIZE_FIELD;
    }


    public void setFigure(Point point, Figure figure) throws InvalidPointException,
                                                             AllreadyOcupaitedException{
        if(!checkPoint(point)){
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }

    public Figure getFigure(Point point) throws InvalidPointException{
        if(!checkPoint(point)){
            throw  new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    private boolean checkPoint (final Point point){
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    private boolean checkCoordinate (final int coordinate){
        return coordinate < MAX_COORDINATE && coordinate >= MIN_COORDINATE;
    }


}
