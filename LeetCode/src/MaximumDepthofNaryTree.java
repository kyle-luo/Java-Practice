//Given a n-ary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


public class MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        if (root != null) return depth(root);
        else return 0;
    }

    private int depth(Node node) {
        int max = 0;
        if (node.children != null) {
            for (Node child: node.children) {
                int dep = depth(child);
                if (dep > max) max = dep;
            }
        }
        return max + 1;
    }
}
