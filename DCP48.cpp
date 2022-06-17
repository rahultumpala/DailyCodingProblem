/*

Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.
For example, given the following preorder traversal:
[a, b, d, e, c, f, g]
And the following inorder traversal:
[d, b, e, a, f, c, g]
You should return the following tree:
    a
   / \
  b   c
 / \ / \
d  e f  g

*/


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int pre=0;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return create(preorder,inorder,0,inorder.size()-1);
    }
    
    TreeNode* create(vector<int>& preorder, vector<int>& inorder,int left,int right){
        if(left > right ) return nullptr;
        
        TreeNode* root = new TreeNode(preorder[pre++]);
        int pos = 0;
        for(int i=left; i<= right; i++){
            if(inorder[i] == root->val){
                pos=i;
                break;
            }
        }
        
        root->left = create(preorder,inorder,left,pos-1);
        root->right = create(preorder,inorder,pos+1,right);
        
        return root;
    }
};
