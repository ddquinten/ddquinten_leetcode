// Leetcode 30-day day 20
// Description from leetcode
/*Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, 
 and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, 
 then traverses node.left, then traverses node.right.)

Notes: 
    1. 1 <= preorder.length <= 100
    2. The values of preorder are distinct.*/

#include <iostream>
#include <vector>


//Definition for a binary tree node.
struct TreeNode 
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
 
class Solution {
public:
    TreeNode* bstFromPreorder(vector<int>& preorder) 
    {
        index = 0;
        return buildBST(preorder, INT_MIN, INT_MAX, preorder[0]);
    }

    TreeNode* buildBST(vector<int>& arr, int min, int max, int current)
    {
        if (index >= arr.size()) // Recursive end condition
            return NULL;

        TreeNode* root = NULL;
      
        if (min < current && current < max) // current belongs in the range, add to BST
        {
            root = new TreeNode(current);
            index++;
            
            if (index < arr.size()) // Incase no more values left in vector
                root->left = buildBST (arr, min, current, arr[index]); // max value is current, because it is now the parent
                // By nature of preorder when we return, 
                // we can assume all values that belong left of current node are there
            if(index < arr.size()) // Still have to check b/c return from left side
                root->right = buildBST (arr, current, max, arr[index]); // min value is current, because it is now the parent
        }
        return root;
    }
private:
    int index;
};

int main()
{
    // Leetcode given test data
    vector<int> preorder1 = {8,5,1,7,10,12};

    TreeNode* root = bstFromPreorder(preorder1);
    // Print implementation not done - but solution works
    // maybe will do later
	return 0;
}


/*
Fastest c++ submission on leetcode NOT MINE
Just wanted to study - beat me by 8ms

class Solution {

public:
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        if (preorder.size() == 0) 
            return NULL;

        TreeNode* root = new TreeNode(preorder[0]);
        stack<TreeNode*> s;
        s.push(root);

        for(int i = 1; i < preorder.size(); i++){
            if(s.top()->val > preorder[i]){
                TreeNode * temp = new TreeNode(preorder[i]);
                s.top()->left = temp;
                s.push(temp); 
            }else {
                TreeNode* child = NULL;
                while(!s.empty()
                      &&s.top()->val < preorder[i]){
                    child = s.top();
                    s.pop();
                }
                TreeNode * newNode = new TreeNode(preorder[i]);
                child->right = newNode;
                s.push(newNode);
            }
        }
        return root;
    }
};
*/