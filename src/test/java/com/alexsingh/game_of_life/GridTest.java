package com.alexsingh.game_of_life;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GridTest 
{
    @Test
    public void size_and_cell_state_working()
    {
        int[][] gridData = { 
            { 1, 0, 0, 0, 0},
            { 0, 1, 0, 0, 0},
            { 0, 0, 0, 1, 1},
            { 0, 1, 1, 1, 0},
            { 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 1},
        };
        Grid grid = new Grid(gridData, 6, 5);
        assertEquals(6, grid.getXSize());
        assertEquals(5, grid.getYSize());
        assertEquals(1, grid.getCellState(0, 0));
        assertEquals(0, grid.getCellState(4, 3));
        assertEquals(1, grid.getCellState(5, 4));
    }

    @Test
    public void thin_vertical_working(){
        int[][] gridData = { 
            { 1 },
            { 1 },
            { 1 },
            { 0 },
        };
        Grid grid = new Grid(gridData, 4, 1);
        Grid nextGrid = grid.createNextGeneration();
        assertEquals(0, nextGrid.getCellState(0, 0));
        assertEquals(1, nextGrid.getCellState(1, 0));
        assertEquals(0, nextGrid.getCellState(2, 0));
        assertEquals(0, nextGrid.getCellState(3, 0));
    }

    @Test
    public void thin_horiziontal_working(){
        int[][] gridData = { 
            { 1, 1, 1, 0}
        };
        Grid grid = new Grid(gridData, 1, 4);
        Grid nextGrid = grid.createNextGeneration();
        assertEquals(0, nextGrid.getCellState(0, 0));
        assertEquals(1, nextGrid.getCellState(0, 1));
        assertEquals(0, nextGrid.getCellState(0, 2));
        assertEquals(0, nextGrid.getCellState(0, 3));
    }

    @Test
    public void normal_case_working(){
        int[][] gridData = { 
            { 1, 0, 1, 0, 0},
            { 0, 1, 1, 0, 0},
            { 0, 1, 0, 1, 1},
            { 0, 1, 1, 1, 0},
            { 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 1},
        };
        Grid grid = new Grid(gridData, 6, 5);
        Grid nextGrid = grid.createNextGeneration();
        assertEquals(0, nextGrid.getCellState(0, 0));
        assertEquals(0, nextGrid.getCellState(1, 1));
        assertEquals(0, nextGrid.getCellState(2, 2));
        assertEquals(1, nextGrid.getCellState(4, 2));
        assertEquals(1, nextGrid.getCellState(3, 1));
    }
}
