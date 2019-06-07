//Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
//
//Example 1:
//Input:
//    3
//   / \
//  9  20
//    /  \
//   15   7
//Output: [3, 14.5, 11]
//Explanation:
//The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            List<Double> output = new ArrayList<>();
            return output;
        }
        else {
            List<TreeNode> nodes = new ArrayList<>(Arrays.asList(root));
            List<Double> output = new ArrayList<>();
            while (!nodes.isEmpty()) {
                double sum = 0;
                List<TreeNode> newNodes = new ArrayList<>();
                for (TreeNode node: nodes) {
                    sum += node.val;
                    if (node.left != null) newNodes.add(node.left);
                    if (node.right != null) newNodes.add(node.right);
                }
                output.add(sum / nodes.size());
                nodes = newNodes;
            }
            return output;
        }
    }
}


public class AverageofLevelsinBinaryTree2 {
    List<List<Integer>> output = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            List<Double> output = new ArrayList<>();
            return output;
        }
        else {
            trav(root, 0);
            List<Double> result = new ArrayList<>();
            for (int i = 0; i < output.size(); i++) {
                double sum = 0;
                List<Integer> list = output.get(i);
                for (int j = 0; j < list.size(); j++) {
                    sum += output.get(i).get(j);
                }
                result.add(sum / list.size());
            }
            return result;
        }
    }
    private void trav(TreeNode node, int depth) {
        depth++;
        if (output.size() < depth) {
            List<Integer> newList= new ArrayList<>();
            output.add(newList);
        }
        List<Integer> temp = output.get(depth - 1);
        temp.add(node.val);
        if (node.left != null) trav(node.left, depth);
        if (node.right != null) trav(node.right, depth);
    }
}
