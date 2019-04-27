import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int gridSize;
    private boolean[][] grid;
    private WeightedQuickUnionUF connect;
    private int top = 0;
    private int bot;
    private int opencount = 0;

    public Percolation(int n)                // create n-by-n grid, with all sites blocked
    {
        gridSize = n;
        grid = new boolean[n][n];
        bot = n * n + 1;
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
        if (row == gridSize) {
            if (isFull(row - 1, col)) connect.union(getIndex(row , col), bot);
            if (col >1 && isFull(row, col - 1)) connect.union(getIndex(row, col - 1), getIndex(row, col));
            if (col < gridSize && isFull(row, col + 1)) connect.union(getIndex(row, col + 1), getIndex(row, col));
        }                                    // prevent all blocks at the bottom row be connected to top
        if (col >1 && isOpen(row, col - 1)) connect.union(getIndex(row, col - 1), getIndex(row, col));
        if (col < gridSize && isOpen(row, col + 1)) connect.union(getIndex(row, col + 1), getIndex(row, col));
        if (row > 1 && isOpen(row - 1, col)) connect.union(getIndex(row - 1, col), getIndex(row, col));
        if (row < gridSize && isOpen(row + 1, col)) connect.union(getIndex(row + 1, col), getIndex(row, col));
    }

    public boolean isOpen(int row, int col)  // is site (row, col) open?
    {
        return grid[row - 1][col - 1];
    }


    public boolean isFull(int row, int col)  // is site (row, col) full?
    {
        return connect.connected(getIndex(row, col), top);
    }

    public int numberOfOpenSites()           // number of open sites
    {
        return opencount;
    }

    public boolean percolates()              // does the system percolate?
    {
        return connect.connected(top, bot);
    }

    private int getIndex(int row, int col) {
        return gridSize * (row - 1) + col;
    }

}
