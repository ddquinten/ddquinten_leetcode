// Leetcode 30-day day 27
// Description from leetcode
/* Given a 2D binary matrix filled with 0's and 1's, 
   find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class day27_maximal_square
{

    //leetcode given function
    // just solution method
    public static int maximalSquare(char[][] matrix) 
    {
        if(matrix == null || matrix.length == 0)
            return 0;

        int row = matrix.length;          
        int column = matrix[0].length;     
        int temp[][] = new int[row][column];      
        // create a 2d array sum matrix
        int result = 0; 
        //assume no '1's in matrix - this will be the longest length of the square of 1's

        // initialize first row - convert char to int
        for(int i = 0; i < row; i++) 
        {
            temp[i][0] = matrix[i][0] - '0'; 
            result = Math.max(result, temp[i][0]); 
            // if the longest length of square is in the first row
        }
      
        // initialize first column - convert char to int
        for(int j = 0; j < column; j++) 
        {
            temp[0][j] = matrix[0][j] - '0'; 
            result = Math.max(result, temp[0][j]); 
            // if the longest length of square is in the first column
        }
          
        /* Construct other entries of temp[][]*/
        for(int i = 1; i < row; i++) 
            for(int j = 1; j < column; j++) 
                if(matrix[i][j] == '1')  
                // search every index of for inst of '1'
                // if there is a match, take the min of the past surrounding 1's (in a square) and add 1 (current positon)
                {
                    temp[i][j] = Math.min(temp[i][j-1], Math.min(temp[i-1][j], temp[i-1][j-1])) + 1;
                    result  = Math.max(result, temp[i][j]); // result is which ever is higher of current and past length
                }
                else
                    temp[i][j] = 0; // '1' not found

        return result * result; // results just length so square it to get total nums of '1's
    }
          
}