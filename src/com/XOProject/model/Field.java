package com.XOProject.model;

import com.XOProject.model.exception.AllreadyOcupaitedException;
import com.XOProject.model.exception.InvalidPointException;

import java.awt.*;

/**
 * Created by vlad on 11.11.15.
 */
public class Field {

    public final int size_field;
    public static final int MIN_COORDINATE = 0;

    final Figure[][] field ;

    public Field(int size_field) {
        this.size_field = size_field;
        field = new Figure[size_field][size_field];
    }

    public int getSize_field(){
        return size_field;
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
    //check point that was within the limits of the field
    private boolean checkPoint (final Point point){
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }
    //check coordinate
    private boolean checkCoordinate (final int coordinate, final int maxCoordinate){
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate ;
    }


}
