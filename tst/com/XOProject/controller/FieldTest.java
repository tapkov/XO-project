package com.XOProject.controller;
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
        final Figure expectedValue = field.getFigure(InputPoint);

        assertEquals(expectedValue, inputValue);
    }
}