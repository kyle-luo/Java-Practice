//Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its depth = 3.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class MaximumDepthofBinaryTree {
    private int max = 0;
    public int maxDepth(TreeNode root) {
        if (root != null) checkdepth(root, 0);
        return max;
    }

    private void checkdepth(TreeNode node, int count) {
        count ++;
        if (node.left != null) checkdepth(node.left, count);
        if (node.right != null) checkdepth(node.right, count);
        else {
            if (count > max) max = count;
        }
    }
}
