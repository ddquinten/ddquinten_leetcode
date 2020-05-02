// Leetcode 30-day day 11
// Given a binary tree, you need to compute the length of the diameter of the tree. 
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
// This path may or may not pass through the root.
// The length of path between two nodes is represented by the number of edges between them.

// just the class solution outline from leetcode


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int diameterOfBinaryTree(TreeNode* root)
    { 
       if (root == NULL) 
         return 0; 

      // get the height of left and right sub-trees
      int hLeft = height(root->left); 
      int hRight = height(root->right); 

      ///get the diameter of left and right sub-trees
      int dLeft = diameterOfBinaryTree(root->left); 
      int dRight = diameterOfBinaryTree(root->right); 

      /* Return which ever is greater
       1) Diameter of left subtree or right subtree 
       2) Height of left subtree + height of right subtree + root(1) */
      return maxValue(hLeft + hRight, maxValue(dLeft, dRight)); 
    }  

    int height(TreeNode* current) 
    // computes height of tree, longest path to lowest leaf from root
    { 
        // base condition
       if(current == NULL) 
           return 0; 

       // If sub-tree is not empty then height = 1(current) + left or right height (whichever is greater)    
       return 1 + maxValue(height(current->left), height(current->right)); 
    }  

    int maxValue(int left, int right) 
    // used to determine which value (height or diameter) is greater
    { 
      return (left >= right)? left: right; 
    }   
};

// Leetcode's 0ms submission for C++
class Solution {
public:
    int max_diameter = 0;
    int diameterOfBinaryTree(TreeNode* root) {
        get_depth(root);
        return max_diameter;
        
    }
    int get_depth(TreeNode* root) {
        if (root == NULL) return 0;
        int left_depth = get_depth(root->left);
        int right_depth = get_depth(root->right);
        max_diameter = max(max_diameter,left_depth+right_depth);
        return max(left_depth, right_depth)+1;

    }
};
