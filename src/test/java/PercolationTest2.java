import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PercolationTest2 {
    @Test
    public void testPercolationForN2() {
        Percolation percolation = new Percolation(2);
        assertFalse("Should not percolate before opening any sites", percolation.percolates());

        percolation.open(1, 1);
        assertFalse("Should not percolate after opening only top-left site", percolation.percolates());

        percolation.open(2, 1);
        assertTrue("Should percolate after opening top-left and bottom-left sites", percolation.percolates());
    }
}
