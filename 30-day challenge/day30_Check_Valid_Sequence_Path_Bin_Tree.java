// Leetcode 30-day day 29
// Description from leetcode
/* Given a binary tree where each path going from the root to any leaf form a valid sequence, 
check if a given string is a valid sequence in such binary tree. 

We get the given string from the concatenation of an array of integers arr and the concatenation of all values 
of the nodes along a path results in a sequence in the given binary tree.

Examples at bottom
*/


//leetcode given function
// just solution method
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return DFS(root, arr, 0);
    }
    
    public boolean DFS(TreeNode root, int[] arr, int index)
    {
        if (index > arr.length - 1) // index is higher than arary bound
            return false;
        if (root.val != arr[index]) // path not a part of sequence
            return false;
        if (root == null && index < (arr.length -1))   
            return false;
        // here means values match, and not a leaf/ more in array- possibly at end
        if (root.left == null && root.right == null) // is a leaf, values match
            if (index == (arr.length - 1))
                return true;
        
        // check child(ren)
        boolean left = false, right = false;
        
        if (root.left != null)
            left = DFS(root.left, arr, index + 1);
        
        if (root.right != null)
            right = DFS(root.right, arr, index + 1);
            
        
        return (left || right);
        // check the dfs on both children of current node. Use or in case of one being true and the other false
    }
}
/* Test Cases
Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
Output: false
Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.

Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
Output: false 
Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.

Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
Output: true
Explanation: 
The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
Other valid sequences are: 
0 -> 1 -> 1 -> 0 
0 -> 0 -> 0

Input: root = [2,9,3,null,1,null,2,null,8], arr = [2,9,1,8,0]
Output: false */