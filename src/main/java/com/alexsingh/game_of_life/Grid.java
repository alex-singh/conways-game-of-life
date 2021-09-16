package com.alexsingh.game_of_life;

public class Grid {
    private final int m;
    private final int n;
    private final int[][] grid;

    // Could be an enum, but kept it like this to make the input matrices easier to visualize, 
    // with 1 and 0.  
    private final int DEAD = 0;
    private final int ALIVE = 1;

    public Grid(int[][] grid, int m, int n){
        this.m = m;
        this.n = n;
        this.grid = cloneGrid(grid, m, n);
    }

    public Grid createNextGeneration(){
        return new Grid(createNextGenerationImpl(), m, n);
    }

    public int getCellState(int x, int y){
        return grid[x][y];
    }

    public int getXSize(){
        return m;
    }

    public int getYSize(){
        return n;
    }

    private int[][] cloneGrid(int[][] grid, int m, int n){
        int[][] clone = new int[m][n];
        for(int i = 0; i < m; i++)
            clone[i] = grid[i].clone();
        return clone;
    }

    private int[][] createNextGenerationImpl(){
        int[][] nextGrid = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int numberOfNeighbors = getNumberOfAliveNeighbors(i, j);
                if ( getCellState(i, j) == ALIVE ){
                    if (numberOfNeighbors < 2 || numberOfNeighbors > 3){
                        nextGrid[i][j] = DEAD;
                    }
                    else{
                        nextGrid[i][j] = ALIVE;
                    }
                }
                if ( getCellState(i, j) == DEAD ){
                    if( numberOfNeighbors == 3 ){
                        nextGrid[i][j] = ALIVE;
                    }
                    else{
                        nextGrid[i][j] = DEAD;
                    }
                }
            }
        }
        return nextGrid;
    }

    private int getNumberOfAliveNeighbors(int x, int y){
        int neighbors = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!isOutsideGrid(i, j) && !(x == i && y == j) && getCellState(i, j) == ALIVE)
                    neighbors += 1;
            }
        }
        return neighbors;
    }

    private boolean isOutsideGrid(int x, int y){
        return x < 0 || x >= m || y < 0 || y >= n;
    }
}
