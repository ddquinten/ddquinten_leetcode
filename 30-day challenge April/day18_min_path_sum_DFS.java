// Leetcode 30-day day 18
// Description from leetcode
/* Given a m x n grid filled with non-negative numbers, find a path from top left to 
   bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.*/

import java.util.ArrayList;
import java.util.Arrays;

// Need DFS
public class day18_min_path_sum_DFS
{
	public static void main(String[] args)
	{
		int[][] grid1 = {{1,3,0},
                         {1,5,1},
                         {4,2,1}}; // given test array -> output is 7

		System.out.println(new day18_min_path_sum_DFS().minPathSum(grid1));

        int[][] grid2 = {{1,4,2,5,2},
                         {2,6,8,4,9},
                         {3,9,8,1,1},
                         {2,3,9,8,4}}; // made test array -> leetcode said output is 3

        System.out.println(new day18_min_path_sum_DFS().minPathSum(grid2));

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

        System.out.println(new day18_min_path_sum_DFS().minPathSum(grid3));

        return;
	}

    //leetcode given function
    public int minPathSum(int[][] grid) 
    {
        return findMinPath(grid, 0, 0);
    }

    private int findMinPath(int[][] grid, int i, int j) 
    /* DFS - starting from top left, continuous search until reach bottom right. At each point
       check the weight of the path from bottom right to current (down and right paths) and 
       return the smallest wieght plus the current position weight.*/
    {
        if (i == grid.length-1 && j == grid[0].length-1)
        // This here means reached bottom right position - just return weight
            return grid[i][j];
         
        int right, left; // path weights

        // Only need to check right and down
        if (i + 1 != grid.length && j + 1 != grid[0].length) 
        // paths of current position arent out of bounds - must check both paths
        {
            right = findMinPath(grid, i + 1, j); // down
            left = findMinPath(grid, i, j + 1); // right
        }
        else if (j + 1 == grid[0].length) // no right path to check
            return grid[i][j] + findMinPath(grid, i + 1, j); // down
        else // not down path to check
            return grid[i][j] + findMinPath(grid, i, j + 1); // right

        return right < left ? grid[i][j] + right : grid[i][j] + left; // return the smallest weight path plus current weight
    }
}
