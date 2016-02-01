/*
    Serialization is the process of converting a data structure or object into a sequence of bits so that it 
    can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed 
    later in the same or another computer environment.
	
	Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
	serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized 
	to a string and this string can be deserialized to the original tree structure.

    Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

    Example: For example, you may serialize the following tree
	    1
	   / \
	  2   3
	     / \
	    4   5
	as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily 
	need to follow this format, so please be creative and come up with different approaches yourself.

    Solution: None
    
    Source: None
*/

import java.util.StringTokenizer;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "";
        if (root == null) {
            result = "# ";
            return result;
        }
        result += root.val + " ";
        result += serialize(root.left);
        result += serialize(root.right);
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode result = null;
        if (data == null || data.length() == 0) {
            return result;
        }
        StringTokenizer st = new StringTokenizer(data, " ");
        return deserialize(st);
    }
    private TreeNode deserialize(StringTokenizer st) {
        if (!st.hasMoreTokens()) {
            return null;
        }
        String val = st.nextToken();
        if (val.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(st);
        root.right = deserialize(st);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));