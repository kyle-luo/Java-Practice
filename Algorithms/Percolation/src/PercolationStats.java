import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {

    private final double[] percentcount;

    public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
    {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("Both Grid size and trails must bigger than 0.");
        percentcount = new double[trials];
        for (int expNum = 0; expNum <= trials; expNum++) {
            Percolation pc = new Percolation(n);
            int open = 0;
            while (!pc.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (!pc.isOpen(row, col)) {
                    pc.open(row, col);
                    open++;
                }
            }
            double percent = (double) open/(n*n);
            percentcount[expNum] = percent;
        }
    }

    public double mean()                          // sample mean of percolation threshold
    {
        return StdStats.mean(percentcount);
    }

    public double stddev()                        // sample standard deviation of percolation threshold
    {
        return StdStats.stddev(percentcount);
    }

    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    {
        return mean() - (1.96 * stddev());
    }
    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {
        return mean() + (1.96 * stddev());
    }

    public static void main(String[] args)        // test client (described below)
    {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, t);
//        PercolationStats PS = new PercolationStats(10, 10);
//        System.out.println("Experiment mean is: " + PS.mean());
//        System.out.println("Experiment standard deviation is: " + PS.stddev());
//        System.out.println("95% confidence interval is from " + PS.confidenceLo() + "to " + PS.confidenceHi());
        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
//        System.out.println("mean                    = " + ps.mean());
//        System.out.println("stddev                  = " + ps.stddev());
//        System.out.println("95% confidence interval = " + confidence);
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }
}
