import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid; // To track open sites
    private int openSites; // To track the number of open sites
    private int top; // Virtual top site index
    private int bottom; // Virtual bottom site index
    private int n; // Grid size
    private WeightedQuickUnionUF uf; // Union-Find structure for percolation (with virtual top and bottom)
    private WeightedQuickUnionUF ufNoBottom; // Union-Find structure to avoid backwash (only virtual top)

    // Constructor
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        this.n = n;
        this.grid = new boolean[n][n];
        this.uf = new WeightedQuickUnionUF(n * n + 2); // +2 for virtual top and bottom
        this.ufNoBottom = new WeightedQuickUnionUF(n * n + 1); // +1 for only virtual top
        top = 0;
        bottom = n * n + 1; // Only used in uf
        // Initialize connection of top row to virtual top node in both UF structures
        for (int col = 1; col <= n; col++) {
            int index = xyTo1D(1, col);
            uf.union(index, top);
            ufNoBottom.union(index, top);
        }

    }

    // Convert 2D indices to 1D index
    private int xyTo1D(int row, int col) {
        return (row - 1) * n + col;
    }

    // Validate indices
    private void validate(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("Row or column index out of bounds");
        }
    }

    // Open site
    public void open(int row, int col) {
        validate(row, col);
        if (!isOpen(row, col)) {
            grid[row - 1][col - 1] = true;
            openSites++; // Increment count of open sites here
            int index = xyTo1D(row, col);

            // Connect newly opened site to adjacent open sites in both UF structures
            if (row == 1) {
                uf.union(index, top);
                ufNoBottom.union(index, top);
            }
            if (row == n) {
                uf.union(index, bottom);
            }

            if (row > 1 && isOpen(row - 1, col)) {
                uf.union(index, xyTo1D(row - 1, col));
                ufNoBottom.union(index, xyTo1D(row - 1, col));
            }
            if (row < n && isOpen(row + 1, col)) {
                uf.union(index, xyTo1D(row + 1, col));
                ufNoBottom.union(index, xyTo1D(row + 1, col));
            }
            if (col > 1 && isOpen(row, col - 1)) {
                uf.union(index, xyTo1D(row, col - 1));
                ufNoBottom.union(index, xyTo1D(row, col - 1));
            }
            if (col < n && isOpen(row, col + 1)) {
                uf.union(index, xyTo1D(row, col + 1));
                ufNoBottom.union(index, xyTo1D(row, col + 1));
            }
        }
    }

    // Check if site is open
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return grid[row - 1][col - 1];
    }

    // Check if site is full

    public boolean isFull(int row, int col) {
        validate(row, col);
        return isOpen(row, col) && ufNoBottom.find(xyTo1D(row, col)) == ufNoBottom.find(top);
    }

    // Number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // Does the system percolate?
    public boolean percolates() {
        if (n == 1) {
            return isOpen(1, 1);
        }
        return openSites > 0 && uf.find(top) == uf.find(bottom);
    }


    // test client (optional)
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Percolation n T");
            return;
        }
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        Percolation percolation = new Percolation(n);
        int totalOpenSites = 0;

        // Open top-left site
        percolation.open(1, 1);
        totalOpenSites++;

        // Open bottom-left site
        percolation.open(n, 1);
        totalOpenSites++;

        System.out.println("Number of open sites: " + totalOpenSites);
        System.out.println("Percolates: " + percolation.percolates());

        for (int i = 0; i < T - 2; i++) {
            int row = StdRandom.uniformInt(1, n + 1);
            int col = StdRandom.uniformInt(1, n + 1);
            if (!percolation.isOpen(row, col)) {
                percolation.open(row, col);
                totalOpenSites++;
            }
            System.out.println("Number of open sites: " + totalOpenSites);
            System.out.println("Percolates: " + percolation.percolates());
        }
    }
}