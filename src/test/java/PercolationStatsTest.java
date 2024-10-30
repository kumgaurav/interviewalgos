import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationStatsTest {

    private static final double EPSILON = 1e-6;

    @Test
    public void testStddevInExpectedRange() {
        testStddevForNAndTrials(2, 10000, 0.114620, 0.121104);
        testStddevForNAndTrials(5, 10000, 0.099839, 0.105487);
        testStddevForNAndTrials(10, 10000, 0.071536, 0.075583);
        testStddevForNAndTrials(25, 10000, 0.040802, 0.043110);
    }

    private void testStddevForNAndTrials(int n, int trials, double lowerBound, double upperBound) {
        PercolationStats stats = new PercolationStats(n, trials);
        double stddev = stats.stddev();

        assertTrue("Stddev for n=" + n + " and trials=" + trials + " should be between " +
                        lowerBound + " and " + upperBound + ", but was " + stddev,
                stddev >= lowerBound - EPSILON && stddev <= upperBound + EPSILON);
    }
}

