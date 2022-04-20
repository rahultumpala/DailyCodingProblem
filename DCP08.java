package DCP;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/*
        --------- Question: ---------
A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1

        --------- End Question ---------
*/
  class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }

public class DCP08 {
    /*
        TC - O(N^2) N - number of nodes in the tree
        Could be optimized to traverse the tree only once..making it O(N) time
     */
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        int ans = helper(root);
        return ans;
    }

    // performs the univaluedness check on all the nodes of the tree
    int helper(TreeNode root){
        if(root == null) return 0;
        int left  = helper(root.left);
        int right = helper(root.right);
        if(isunival(root,root.val)) return left + right + 1;
        return left + right;
    }

    // checks if the given tree is a univalued tree. TC - O(N)
    boolean isunival(TreeNode root, int val){
        if(root == null) return true;
        if(root.val != val) return false;
        return isunival(root.left,val) && isunival(root.right,val);
    }

}
