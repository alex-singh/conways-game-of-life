package com.alexsingh.game_of_life;

public class App 
{
    public static void main( String[] args )
    {
        // Initial grid. Input data from user.
        int M = 6, N = 5, nrOfGenerations = 6;
        int[][] gridData = { 
            { 0, 0, 1, 0, 0},
            { 0, 0, 1, 0, 0},
            { 0, 0, 1, 0, 0},
            { 0, 0, 1, 0, 0},
            { 0, 0, 1, 0, 0},
            { 0, 0, 1, 0, 0},
        };

        Grid grid = new Grid(gridData, M, N);
        GridPrinter.print(grid);
        for (int i = 0; i < nrOfGenerations; i++){
            grid = grid.createNextGeneration();
            GridPrinter.print(grid);
        }
    }
}
