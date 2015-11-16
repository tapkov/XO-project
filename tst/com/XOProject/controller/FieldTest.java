package com.XOProject.controller;
import com.XOProject.controller.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;
import java.lang.reflect.*;


import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetFigure() throws Exception {
        Figure inputValue = Figure.X;
        Point InputPoint = new Point(0,0);

        Field field = new Field();

        field.setFigure(InputPoint, inputValue);
        Figure expectedValue = field.getFigure(InputPoint);

        assertEquals(expectedValue, inputValue);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        Point InputPoint = new Point(0,0);
        Field field = new Field();

        Figure actualFigure = field.getFigure(InputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThanZero() throws Exception {
        Point InputPoint = new Point(-1,0);
        Field field = new Field();
        try {
            field.getFigure(InputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }
    @Test
    public void testGetFigureWhenYIsLessThanZero() throws Exception {
        Point InputPoint = new Point(0,-1);
        Field field = new Field();
        try {
            field.getFigure(InputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }
    @Test
    public void testGetFigureWhenXIsMoreThanZero() throws Exception {
        Field field = new Field();
        Point InputPoint = new Point(field.getSizeField() + 1,0);

        try {
            field.getFigure(InputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }
    @Test
    public void testGetFigureWhenYIsMoreThanZero() throws Exception {
        Field field = new Field();
        Point InputPoint = new Point(0, field.getSizeField() + 1);

        try {
            field.getFigure(InputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }
}