package com.alexsingh.game_of_life;

public class GridPrinter{

    // private constructor to prevent instantiation.
    private GridPrinter(){}

    public static void print(Grid grid){
        for (int i = 0; i < grid.getXSize(); i++)
        {
            for (int j = 0; j < grid.getYSize(); j++)
            {
                if (grid.getCellState(i, j) == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
}