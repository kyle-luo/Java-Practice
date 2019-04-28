import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] percentcount;

    public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
    {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("Both Grid size and trails must bigger than 0.");
        percentcount = new double[trials];
        for (int expNum = 0; expNum <= trials; expNum++){
            Percolation pc = new Percolation(n);
            int open = 0;
            while (!pc.percolates()) {
                int row = StdRandom.uniform(1, n);
                int col = StdRandom.uniform(1, n);
                if (!pc.isOpen(row, col)) {
                    pc.open(row, col);
                    open++;
                }
            double percent = (double) open/(n*n);
            percentcount[expNum] = percent;
            }
        }
    }

    public double mean()                          // sample mean of percolation threshold
    {
        double mean = StdStats.mean(percentcount);
        return mean;
    }

    public double stddev()                        // sample standard deviation of percolation threshold
    {
        double std = StdStats.stddev(percentcount);
        return std;
    }

    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    {
        double low = mean() - (1.96 * stddev());
        return low;
    }
    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {
        double high = mean() + (1.96 * stddev());
        return high;
    }

    public static void main(String[] args)        // test client (described below)
    {
        int n = (int) (Math.random() * 10 + 1);
        int T = (int) (Math.random() * 10 + 1);
        PercolationStats PS = new PercolationStats(n, T);
//        PercolationStats PS = new PercolationStats(10, 10);
        System.out.println("Experiment mean is: " + PS.mean() );
        System.out.println("Experiment standard deviation is: " + PS.stddev());
        System.out.println("95% confidence interval is from " + PS.confidenceLo() + "to " + PS.confidenceHi());
    }
}
