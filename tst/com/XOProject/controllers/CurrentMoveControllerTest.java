package com.XOProject.controllers;

import com.XOProject.model.Field;
import com.XOProject.model.Figure;
import org.junit.Test;

import java.awt.*;
import java.util.Random;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveWhenCurrentMoveIsX() throws Exception {
        final Field field = new Field(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Figure expectedValue = Figure.X;

        field.setFigure(new Point(0,0), Figure.O);
        field.setFigure(new Point(1,0), Figure.O);
        field.setFigure(new Point(0,2), Figure.O);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,0), Figure.X);

        assertEquals(expectedValue, currentMoveController.currentMove(field));
    }

    @Test
    public void testCurrentMoveWhenCurrentMoveIsO() throws Exception {
        final Field field = new Field(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Figure expectedValue = Figure.O;

        field.setFigure(new Point(0,0), Figure.O);
        field.setFigure(new Point(1,0), Figure.O);
        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,0), Figure.X);

        assertEquals(expectedValue, currentMoveController.currentMove(field));
    }

    @Test
    public void testCurrentMoveWhenFieldIsFull() throws Exception {
        final Field field = new Field(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();

        field.setFigure(new Point(0,0), Figure.O);
        field.setFigure(new Point(1,0), Figure.O);
        field.setFigure(new Point(2,0), Figure.X);
        field.setFigure(new Point(0,1), Figure.X);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,1), Figure.O);
        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(1,2), Figure.X);
        field.setFigure(new Point(2,2), Figure.X);

        assertNull(currentMoveController.currentMove(field));
    }



}