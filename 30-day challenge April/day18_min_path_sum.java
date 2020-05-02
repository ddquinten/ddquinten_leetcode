// Leetcode 30-day day 18
// Description from leetcode
/* Given a m x n grid filled with non-negative numbers, find a path from top left to 
   bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class day18_min_path_sum
{
	public static void main(String[] args)
	{
		int[][] grid1 = {{1,3,0},
                         {1,5,1},
                         {4,2,1}}; // given test array -> output is 7

		System.out.println(new day18_min_path_sum().minPathSum(grid1));

        int[][] grid2 = {{1,4,2,5,2},
                         {2,6,8,4,9},
                         {3,9,8,1,1},
                         {2,3,9,8,4}}; // made test array -> leetcode said output is 3

        System.out.println(new day18_min_path_sum().minPathSum(grid2));

        int[][] grid3 = {{3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},
                         {0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},
                         {8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},
                         {1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},
                         {8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},
                         {4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},
                         {6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},
                         {8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},
                         {9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},
                         {0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},
                         {4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},
                         {2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},
                         {0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},
                         {0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},
                         {6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},
                         {7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},
                         {3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},
                         {5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}}; // failed case - time limit Exceeded (code works but takes too long for leetcode)

        System.out.println(new day18_min_path_sum().minPathSum(grid3));

        return;
	}

    //leetcode given function
    public int minPathSum(int[][] grid) 
    {
        if (grid == null || grid.length == 0)
            return 0;
         
        int height = grid.length;
        int width = grid[0].length;
         
        int[][] tempGrid = new int[height][width];
         
        tempGrid[0][0] = grid[0][0]; // top left position
         
        // initialize the first row - finds weights for taking straight right path
        for (int i = 1; i < width; i++)
            tempGrid[0][i] = tempGrid[0][i - 1] + grid[0][i];
         
        // initialize the first column - find weights for taking straight down path
        for (int i = 1; i < height; i++) 
            tempGrid[i][0] = tempGrid[i - 1][0] + grid[i][0];
        
        /* look at each poistion after first row and columns. Using tempGrid, we can find the 
            weight of the path by adding to grid[i][j] the one above and to the left of it. Since
            we care about smallest path, we take the smallest of the up and right, add that to grid[i][j]
            and store it in tempGrid[i][j]. By the time we get to the bottom right, we will have the 
            smallest weight*/
        for (int i = 1; i < height; i++) 
            for (int j = 1; j < width; j++) 
                tempGrid[i][j] = Math.min(tempGrid[i - 1][j], tempGrid[i][j - 1]) + grid[i][j];
         
        return tempGrid[height - 1][width - 1]; // bottom right position
    }
}
