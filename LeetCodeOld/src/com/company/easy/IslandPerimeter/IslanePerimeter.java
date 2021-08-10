package com.company.easy.IslandPerimeter;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * Created by ogl4jo3 on 2017/2/25.
 */
public class IslanePerimeter {
    public static void main(String[] args) {
        // write your code here
        int[][] grid = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        int n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    n += 4;
                    if (j > 0 && grid[i][j - 1] == 1)
                        n -= 2;
                    if (i > 0 && grid[i - 1][j] == 1)
                        n -= 2;
                }
            }
        }
        System.out.print(n);
    }
}
