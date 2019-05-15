//Given an n-ary tree, return the preorder traversal of its nodes' values.

public class NAryTreePreorderTraversal {
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> output = new ArrayList();
            if (root != null) {
                traversal(root, output);
            }
            return output;
        }

        private void traversal (Node node, List<Integer> list) {
            list.add(node.val);
            if (node.children != null) {
                for (Node child: node.children) {
                    traversal(child, list);
                }
            }
        }
    }
}
