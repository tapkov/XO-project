package com.XOProject.controller;

import java.awt.*;

/**
 * Created by vlad on 11.11.15.
 */
public class Field {

    public static final int SIZE_FIELD = 3;

    Figure[][] field = new Figure[SIZE_FIELD][SIZE_FIELD];

    public void setFigure(Point point, Figure figure){
        field[point.x][point.y] = figure;
    }

    public Figure getFigure(Point point){
        return field[point.x][point.y];
    }

}
