/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here

        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;

        return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);

    }

    public TreeNode construct(int[] preorder, int preStart,
    int preEnd, int[] inorder, int inStart, int inEnd){
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }

        int val = preorder[preStart];
        TreeNode p = new TreeNode(val);

        //find parent element index from inorder
        int k = 0;
        for (int i = 0; i < inorder.length; i++){
            if (val == inorder[i]){
                k = i;
                break;
            }
        }

        p.left = construct(preorder, preStart + 1, preStart
            + (k - inStart), inorder, inStart, k - 1);
        p.right = construct(preorder, preStart + (k - inStart) + 1, preEnd, inorder, k + 1 , inEnd);

        return p;
    }

}
