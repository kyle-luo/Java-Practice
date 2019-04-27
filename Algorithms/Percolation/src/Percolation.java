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
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                grid[i - 1][j - 1] = false;
//            }
//        }
    }

    public void open(int row, int col)       // open site (row, col) if it is not open already
    {
//        if (isOpen(row, col) == false) {
            grid[row - 1][col - 1] = true;
//            opencount++;
//        }
        if (row == 1) connect.union(col, top);
        else if (row == gridSize) connect.union(getIndex(row , col), bot);
        else {
            if (isOpen(row, col - 1)) connect.union(getIndex(row, col - 1), getIndex(row, col));
            else if (isOpen(row, col + 1)) connect.union(getIndex(row, col + 1), getIndex(row, col));
            else if (isOpen(row - 1, col)) connect.union(getIndex(row, col - 1), getIndex(row, col));
            else if (isOpen(row + 1, col)) connect.union(getIndex(row, col + 1), getIndex(row, col));
        }
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

    private int getIndex(int i, int j) {
        return gridSize * (i - 1) + j;
    }

}
