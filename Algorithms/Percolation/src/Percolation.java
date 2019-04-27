import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int gridSize;
    private boolean[][] grid;
    private WeightedQuickUnionUF blocks;
    public Percolation(int n)                // create n-by-n grid, with all sites blocked
    {
        gridSize = n;
        grid = new boolean[n][n];
        blocks = new WeightedQuickUnionUF(n*n);
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++){
                grid[i][j] = false;
            }
        }
    }
    public void open(int row, int col)       // open site (row, col) if it is not open already
    {
        
    }
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public int numberOfOpenSites()           // number of open sites
//    public boolean percolates()              // does the system percolate?
//
//    public static void main(String[] args)   // test client (optional)
}
