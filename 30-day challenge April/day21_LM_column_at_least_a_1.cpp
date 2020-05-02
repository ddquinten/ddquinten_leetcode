// Leetcode 30-day day 20
// Description from leetcode
/*(This problem is an interactive problem.)

A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.

Constraints:

1 <= mat.length, mat[i].length <= 100
mat[i][j] is either 0 or 1.
mat[i] is sorted in a non-decreasing way.*/



// Only the solution function since no access to how BinaryMartix is made
// (Guess i could make my own but whatever)

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * class BinaryMatrix {
 *   public:
 *     int get(int x, int y);
 *     vector<int> dimensions();
 * };
 */

class Solution {
public:
    int leftMostColumnWithOne(BinaryMatrix &binaryMatrix) {
        vector<int> dims = binaryMatrix.dimensions(); // returns [n, m]
        // Matrix is a n * m, so n = # of rows and m = # of columns
        
        int n = dims[0], row = 0; // initialize row for loop
        int m = dims[1], col = m - 1; // initialize col for loop

        // The idea is that we start at the top right of matrix,
        // Because of the way the martix is sorted, we can move left or down
        // to look for the first occurance of 1,
        // Eg - if 1 happens to be in the 2nd row of the last column, we know
        // that if another 1 exist, it can only be on the rows below the 
        // current row/can't be above - we can also move to the left one column
        
        int leftmost = -1; // If we never find a 1 return -1
        while (row < n && col >= 0)
            if (binaryMatrix.get(row, col) == 1)
            {
                leftmost = col;
                col--;
            }
            else
                row++;
        
        return leftmost;
        
    }
};

/* Sample outputs

Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
[0,0,0,1]
[0,0,1,1]
[0,1,1,1]
Output: 1

Input: mat = [[0,0],[0,1]]
[0,0]
[0,1]
Output: 1

Input: mat = [[0,0],[1,1]]
[0,0]
[1,1]
Output: 0