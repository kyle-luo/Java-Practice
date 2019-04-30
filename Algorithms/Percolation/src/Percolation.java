import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int gridSize;
    private boolean[][] grid;
    private final WeightedQuickUnionUF connect;
    private static final int top = 0;
//    private final int bot;
    private int opencount = 0;

    public Percolation(int n)                // create n-by-n grid, with all sites blocked
    {
        if (n >= 1)  gridSize = n;
        else throw new IllegalArgumentException();
        grid = new boolean[n][n];
        connect = new WeightedQuickUnionUF(n * n + 2);
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                grid[row - 1][col - 1] = false;
            }
        }
    }

    public void open(int row, int col)       // open site (row, col) if it is not open already
    {
        if (!isOpen(row, col)) {
            grid[row - 1][col - 1] = true;
            opencount++;
        }
        if (row == 1) connect.union(getIndex(row, col), top);
//        if (row == gridSize) {
//            if (isFull(row - 1, col)) {
//                connect.union(getIndex(row, col), bot);
//                connect.union(getIndex(row - 1, col), getIndex(row, col));
//            }
//            if (col > 1 && isFull(row, col - 1)) connect.union(getIndex(row, col - 1), getIndex(row, col));
//            if (col < gridSize && isFull(row, col + 1)) connect.union(getIndex(row, col + 1), getIndex(row, col));
//        }                                    // prevent all blocks at the bottom row be connected to top
//        if (col > 1 && isOpen(row, col - 1)) connect.union(getIndex(row, col - 1), getIndex(row, col));
//        if (col < gridSize && isOpen(row, col + 1)) connect.union(getIndex(row, col + 1), getIndex(row, col));
//        if (row > 1 && isOpen(row - 1, col)) connect.union(getIndex(row - 1, col), getIndex(row, col));
//        if (row < gridSize && isOpen(row + 1, col)) connect.union(getIndex(row + 1, col), getIndex(row, col));
        if (col > 1 && isOpen(row, col - 1)) connect.union(getIndex(row, col - 1), getIndex(row, col));
        if (col < gridSize && isOpen(row, col + 1)) connect.union(getIndex(row, col + 1), getIndex(row, col));
        if (row > 1 && isOpen(row - 1, col)) connect.union(getIndex(row - 1, col), getIndex(row, col));
        if (row < gridSize && isOpen(row + 1, col)) connect.union(getIndex(row + 1, col), getIndex(row, col));
    }

    public boolean isOpen(int row, int col)  // is site (row, col) open?
    {
        if (row < 1 || row > gridSize || col < 1 || col > gridSize) throw new IllegalArgumentException();
        else return grid[row - 1][col - 1];
    }


    public boolean isFull(int row, int col)  // is site (row, col) full?
    {
        if (row < 1 || row > gridSize || col < 1 || col > gridSize) throw new IllegalArgumentException();
        else return connect.connected(getIndex(row, col), top);
    }

    public int numberOfOpenSites()           // number of open sites
    {
        return opencount;
    }

    public boolean percolates()              // does the system percolate?
    {
        for (int i = gridSize * (gridSize - 1) + 1; i <= gridSize * gridSize; i++) {
            if (connect.connected(top, i)) return true;
        }
        return false;
    }

    private int getIndex(int row, int col) {
        return gridSize * (row - 1) + col;
    }

}
