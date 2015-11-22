package com.XOProject.controllers;

import com.XOProject.model.Field;
import com.XOProject.model.Figure;
import org.junit.Test;

import java.awt.*;

import static com.XOProject.model.Figure.*;
import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenWinnerRow() throws Exception {
        WinnerController winnerController = new WinnerController();

        for(int i = 1; i < 3; i++){
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.X);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
            }
        }

    @Test
    public void testGetWinnerWhenNoWinnerRow() throws Exception {
        WinnerController winnerController = new WinnerController();

        for(int i = 1; i < 3; i++){
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.X);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerColumn() throws Exception {
        WinnerController winnerController = new WinnerController();

        for(int i = 1; i < 3; i++){
            final Field field = new Field(3);
            field.setFigure(new Point(0,i), Figure.X);
            field.setFigure(new Point(1,i), Figure.X);
            field.setFigure(new Point(2,i), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        WinnerController winnerController = new WinnerController();

        for(int i = 1; i < 3; i++){
            final Field field = new Field(3);
            field.setFigure(new Point(0,i), Figure.X);
            field.setFigure(new Point(1,i), Figure.X);
            field.setFigure(new Point(2,i), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerDiagram1() throws Exception {
        WinnerController winnerController = new WinnerController();


            final Field field = new Field(3);
            field.setFigure(new Point(0,0), Figure.X);
            field.setFigure(new Point(1,1), Figure.X);
            field.setFigure(new Point(2,2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));

    }


   @Test
   public void testGetWinnerWhenWinnerDiagram2() throws Exception {
        WinnerController winnerController = new WinnerController();


        final Field field = new Field(3);
        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,0), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));

    }

    @Test
    public void testGetWinnerWhenNoWinnerDiagram1() throws Exception {
        WinnerController winnerController = new WinnerController();


        final Field field = new Field(3);
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(1,1), Figure.O);
        field.setFigure(new Point(2,2), Figure.X);
        assertNull(winnerController.getWinner(field));

    }

    @Test
    public void testGetWinnerWhenNoWinnerDiagram2() throws Exception {
        WinnerController winnerController = new WinnerController();


        final Field field = new Field(3);
        field.setFigure(new Point(0,2), Figure.O);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,0), Figure.X);
        assertNull(winnerController.getWinner(field));

    }



    }
