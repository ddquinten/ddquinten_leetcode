// Leetcode 30-day day 17
// Description from leetcode
/* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
   An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
   You may assume all four edges of the grid are all surrounded by water.*/

import java.util.ArrayList;
import java.util.Arrays;

// Need DFS
public class day17_number_of_islands
{
    private int height = 0; // height of grid
    private int width = 0; // width of grid
    
	public static void main(String[] args)
	{
		char[][] grid1 = {{'1','1','1','1','0'},
                          {'1','1','0','1','0'},
                          {'1','1','0','0','0'},
                          {'0','0','0','0','0'}}; // given test array -> output is 1

		System.out.println(new day17_number_of_islands().numIslands(grid1));

        char[][] grid2 = {{'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}}; // given test array -> output is 3

        System.out.println(new day17_number_of_islands().numIslands(grid2));

        return;
	}

    //leetcode given function
    public int numIslands(char[][] grid) 
    {
        // create copy 2d array of bools for visited
        height = grid.length;
        if (height == 0)
            return 0;
        width = grid[0].length;

        boolean[][] visited = new boolean[height][width];

        int islands = 0;

        // iterate through whole grid O(m*n)
        for (int i = 0; i < grid.length; i++) 
            for (int j = 0; j < grid[0].length; j++) 
                if (!visited[i][j] && grid[i][j] == '1') // found a new piece of land
                {
                    checkAdjacent(grid, visited, i, j); // update DFS 2d array
                    // after DFS all lands '1' connected to current land will be checked
                    islands++; // update number of islands
                }

        return islands;
 
    }

    private void checkAdjacent(char[][] grid, boolean[][] visited, int i, int j) 
    /* DFS -used to check if current postion has land next to it (assuming current position is land)
        if it is land, function will continue to check all adjacent positions to its nieghbors, until
        grid edge is reach (considered water), or the positon is surround by a combination of water and
        visited land */
    {
        if (i < 0 || i >= height || j < 0 || j >= width || visited[i][j] || grid[i][j] != '1')
        /* This here means the index is out of bounds (treated as water in this case), has
            been visited already, or is just water ('0') - just return*/
            return;

        visited[i][j] = true; // otherwise, new unvisited land 

        // Only need to check horizonally and vertically
        checkAdjacent(grid, visited, i + 1, j); // up
        checkAdjacent(grid, visited, i - 1, j); // down
        checkAdjacent(grid, visited, i, j + 1); // right
        checkAdjacent(grid, visited, i, j - 1); // left
        return;
    }
}
