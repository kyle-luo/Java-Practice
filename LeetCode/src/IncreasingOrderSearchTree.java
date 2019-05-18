//Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
//
//        Example 1:
//        Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
//        Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

public class IncreasingOrderSearchTree {
    private ArrayList<Integer> order = new ArrayList<Integer>();
    public TreeNode increasingBST(TreeNode root) {
        order(root);
        TreeNode cur = new TreeNode(order.get(0));
        TreeNode newTree = cur;
        for (int i = 0; i < order.size() - 1; i++) {
            cur.right = new TreeNode(order.get(i + 1));
            cur = cur.right;
        }
        return newTree;
    }

    private void order(TreeNode node) {
        if (node.left != null) order(node.left);
        order.add(node.val);
        if (node.right != null) order(node.right);
    }
}
