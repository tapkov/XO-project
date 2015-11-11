package com.XOProject.controller;

import static org.junit.Assert.*;

public class PlayerTest {

    @org.junit.Test
    public void testGetName() throws Exception {
        String inputValue = "Nikki";
        final String expectedValue = "Nikki";

        Player player = new Player(inputValue, null);

        String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);

    }

    @org.junit.Test
    public void testGetFigure() throws Exception {

        Figure inputValue = Figure.X;
        final Figure expectedValue = Figure.X;

        Player player = new Player(null, inputValue);

        Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);

    }
}