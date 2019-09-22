import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {
                        // Replace this code with a faster implementation
//			int maxHeight = 0;
//			for (int vertex = 0; vertex < n; vertex++) {
//				int height = 0;
//				for (int i = vertex; i != -1; i = parent[i])
//					height++;
//				maxHeight = Math.max(maxHeight, height);
//			}
//			return maxHeight;
			Tree tree = new Tree();
			tree.createTree(parent, n);
			return tree.check_depth();
		}
	}

	class Node{
		int val;
		List<Node> child = new ArrayList<>();
	}

	class Tree{
		Node root = null;
		Node[] created;
		public void createTree (int[] parent, int n) {
			created = new Node[n];
			for (int i = 0; i < n; i++) {
				created[i] = new Node();
				created[i].val = i;
			}
			for (int i = 0; i < n; i++) {
//            System.out.println(parent[i]);
				insert(parent[i], i);
			}
		}

		public void insert(int parent, int i) {
			if (parent == -1) root = created[i];
			else {
//            System.out.println(i);
				created[parent].child.add(created[i]);
			}
		}

		public int check_depth(){
			if (root != null) return check_node_depth(root);
			else return -1;
		}

		private int check_node_depth(Node node) {
			int big = 1;
			if (node.child.size() != 0) {
				for (int i = 0; i < node.child.size(); i++) {
					int temp = check_node_depth(node.child.get(i)) + 1;
					if (temp > big) big = temp;
				}
			}
			return big;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
