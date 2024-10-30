import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] percolationThresholds;
    private double mean;
    private double stddev;
    private int trials;


    private static final double CONFIDENCE_95 = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n and trials must be positive integers");
        }

        this.percolationThresholds = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int iterationCount = 0;
            int maxIterations = n * n;
            while (!percolation.percolates() ) { //&& iterationCount < maxIterations
                int row = StdRandom.uniformInt(1, n + 1);
                int col = StdRandom.uniformInt(1, n + 1);
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                }
                iterationCount++;
            }
            percolationThresholds[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(this.percolationThresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        if (percolationThresholds.length <= 1) {
            return Double.NaN;
        }
        return StdStats.stddev(this.percolationThresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        double mean = mean();
        double stddev = stddev();
        return mean - CONFIDENCE_95 * stddev / Math.sqrt(this.percolationThresholds.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        double mean = mean();
        double stddev = stddev();
        return mean + CONFIDENCE_95 * stddev / Math.sqrt(this.percolationThresholds.length);
    }

    // test client (see below)
    public static void main(String[] args){
        if (args.length != 2) {
            System.out.println("Usage: java PercolationStats n T");
            return;
        }
        try {
            int n = Integer.parseInt(args[0]);
            int trials = Integer.parseInt(args[1]);
            PercolationStats stats = new PercolationStats(n, trials);

            System.out.printf("mean                    = %f%n", stats.mean());
            System.out.printf("stddev                  = %f%n", stats.stddev());
            System.out.printf("95%% confidence interval = [%f, %f]%n", stats.confidenceLo(), stats.confidenceHi());
        } catch (NumberFormatException e) {
            System.out.println("Arguments must be integers.");
        }
    }

}