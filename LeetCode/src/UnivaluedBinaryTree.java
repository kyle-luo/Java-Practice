//A binary tree is univalued if every node in the tree has the same value.
//
//Return true if and only if the given tree is univalued.

public class UnivaluedBinaryTree {
    private int key;
    private boolean result = true;
    public boolean isUnivalTree(TreeNode root) {
        if (root != null) {
            key = root.val;
            checkVal(root);
        }
        return result;

    }

    private void checkVal(TreeNode node) {
        if (node.val != key) result = false;
        else{
            if (node.left != null) checkVal(node.left);
            if (node.right != null) checkVal(node.right);
        }
    }
}
