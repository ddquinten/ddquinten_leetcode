// Leetcode 30-day day 29
// Description from leetcode
/* Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.

Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
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
    public int maxPathSum(TreeNode root) {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        subTreeSum(root);
        return maxHeap.peek();
    }
 
    public int subTreeSum(TreeNode root)
    {
        if (root == null)
            return 0;
        
       
        int left = subTreeSum(root.left);
        int right = subTreeSum(root.right);
        int max = Math.max(Math.max(left, right) + root.val, root.val);
        maxHeap.add(Math.max(max, left + right + root.val));
        
        return max;
    }
    
    private PriorityQueue<Integer> maxHeap;
}


// leetcode fastest java runtime - not mine
class Solution {
    int max_path_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return max_path_sum;
    }

    public int maxPathSumUtil(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSumUtil(root.left));
        int right = Math.max(0, maxPathSumUtil(root.right));
        max_path_sum = Math.max(left + right + root.val, max_path_sum);
        return Math.max(left, right) + root.val;
    }