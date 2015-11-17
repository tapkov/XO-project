package com.XOProject.controller;
import com.XOProject.model.*;
import com.XOProject.model.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;


import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetFigure() throws Exception {
        Figure inputValue = Figure.X;
        Point InputPoint = new Point(0,0);

        com.XOProject.model.Field field = new com.XOProject.model.Field(3);

        field.setFigure(InputPoint, inputValue);
        Figure expectedValue = field.getFigure(InputPoint);

        assertEquals(expectedValue, inputValue);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        Point InputPoint = new Point(0,0);
        com.XOProject.model.Field field = new com.XOProject.model.Field(3);

        Figure actualFigure = field.getFigure(InputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThanZero() throws Exception {
        Point InputPoint = new Point(-1,0);
        com.XOProject.model.Field field = new com.XOProject.model.Field(3);
        try {
            field.getFigure(InputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }
    @Test
    public void testGetFigureWhenYIsLessThanZero() throws Exception {
        Point InputPoint = new Point(0,-1);
        com.XOProject.model.Field field = new com.XOProject.model.Field(3);
        try {
            field.getFigure(InputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }
    @Test
    public void testGetFigureWhenXIsMoreThanZero() throws Exception {
        com.XOProject.model.Field field = new com.XOProject.model.Field(3);
        Point InputPoint = new Point(field.getSize_field() + 1,0);

        try {
            field.getFigure(InputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }
    @Test
    public void testGetFigureWhenYIsMoreThanZero() throws Exception {
        com.XOProject.model.Field field = new com.XOProject.model.Field(3);
        Point InputPoint = new Point(0, field.getSize_field() + 1);

        try {
            field.getFigure(InputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }
}