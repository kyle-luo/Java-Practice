//Given an n-ary tree, return the postorder traversal of its nodes' values.

public class NaryTreePostorderTraversal {
    private List<Integer> output = new ArrayList();
    public List<Integer> postorder(Node root) {
        if (root == null) return output;
        else {
            traversal(root, output);
            return output;
        }
    }

    private void traversal(Node node, List<Integer> output) {
        if (node.children != null) {
            for (Node child: node.children) {
                traversal(child, output);
            }
            output.add(node.val);
        }
        else output.add(node.val);
    }
}
