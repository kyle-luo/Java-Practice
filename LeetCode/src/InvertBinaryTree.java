//Invert a binary tree.
//
//Example:
//
//Input:
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//Output:
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        else {
            trim(root);
            return root;
        }
    }

    private void trim(TreeNode node) {
        if (node.left != null && node.right != null) {
            trim(node.left);
            trim(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        else if (node.left != null) {
            trim(node.left);
            node.right = node.left;
            node.left = null;
        }
        else if (node.right != null) {
            trim(node.right);
            node.left = node.right;
            node.right = null;
        }
    }
}
