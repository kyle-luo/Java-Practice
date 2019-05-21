//We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.
//
//Additionally, we are given a cell in that matrix with coordinates (r0, c0).
//
//Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)
//
//
//Example 1:
//Input: R = 1, C = 2, r0 = 0, c0 = 0
//Output: [[0,0],[0,1]]
//Explanation: The distances from (r0, c0) to other cells are: [0,1]
//
//Example 2:
//Input: R = 2, C = 2, r0 = 0, c0 = 1
//Output: [[0,1],[0,0],[1,1],[1,0]]
//Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
//The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
//
//Example 3:
//Input: R = 2, C = 3, r0 = 1, c0 = 2
//Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
//Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
//There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].



public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, ArrayList<int[]>> count = new HashMap();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dist = Math.abs(i - r0) + Math.abs(j - c0);
                int[] coor = {i, j};
                try {
                    ArrayList<int[]> nval = new ArrayList<>();
                    nval = count.get(dist);
                    nval.add(coor);
                    count.put(dist, nval);
                }
                catch (Exception e) {
                    ArrayList<int[]> val = new ArrayList<>();
                    val.add(coor);
                    count.put(dist, val);
                }
            }
        }
        int[][] output = new int[R * C][];
        int i = 0;
        for (int key: count.keySet()) {
            for (int[] temp : count.get(key)) {
                output[i++] = temp;
            }
        }
        return output;
    }
}


public class MatrixCellsInDistanceOrder2 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, ArrayList<int[]>> count = new HashMap();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dist = Math.abs(i - r0) + Math.abs(j - c0);
                int[] coor = {i, j};
                ArrayList<int[]> nval = count.getOrDefault(dist, new ArrayList<>());
                nval.add(coor);
                count.put(dist, nval);
            }
        }
        int[][] output = new int[R * C][];
        int i = 0;
        for (int key: count.keySet()) {
            for (int[] temp : count.get(key)) {
                output[i++] = temp;
            }
        }
        return output;
}
