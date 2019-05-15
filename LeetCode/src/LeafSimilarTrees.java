//Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
//
//For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
//Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
//Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

import java.util.List;

public class LeafSimilarTrees {
    class Solution {
        private List<Integer> root1Leafs = new ArrayList();
        private List<Integer> root2Leafs = new ArrayList();
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            leafs(root1, root1Leafs);
            leafs(root2, root2Leafs);
            return root1Leafs.equals(root2Leafs);
        }

        public void leafs(TreeNode node, List<Integer> list) {
            if(node.left != null) {
                leafs(node.left, list);
            }
            else {
                if(node.right == null) {
                    list.add(node.val);
                }
            }
            if(node.right != null) {
                leafs(node.right, list);
            }
            else {
                if(node.left == null) {
                    list.add(node.val);
                }
            }
        }
    }
}
