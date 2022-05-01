package DCP;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/*
        --------- Question: ---------
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'

        --------- End Question ---------
*/
public class DCP03 {
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        String cur = Integer.toString(root.val);
        if(root.left != null) cur += "L" + serialize(root.left) + ">";
        if(root.right != null) cur += "R" + serialize(root.right) + ">";
        return cur;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0 || this.index >= data.length())
            return null;
        TreeNode root = new TreeNode(0);
        root.val = this.extractNum(data);
        if(this.index >= data.length() || data.charAt(this.index) == '>'){
            this.index++;
            return root;
        }
        if(data.charAt(this.index) == 'L'){
            this.index ++;
            root.left = deserialize(data);
        }
        if(this.index >= data.length() || data.charAt(this.index) == '>'){
            this.index++;
            return root;
        }
        if(data.charAt(this.index) == 'R'){
            this.index ++;
            root.right = deserialize(data);
        }
        if(this.index >= data.length() || data.charAt(this.index) == '>'){
            this.index++;
            return root;
        }
        return root;
    }
    
    private int extractNum(String s){
        String k = "";
        while (this.index < s.length() && s.charAt(this.index) != '>' && s.charAt(this.index) != 'L' && s.charAt(this.index) != 'R'){
            k += Character.toString(s.charAt(this.index));
            this.index++;
        }
        return k.length() == 0 ? 0 : Integer.parseInt(k);
    }
    
}
