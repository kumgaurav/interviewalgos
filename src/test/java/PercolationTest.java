import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationTest {

    @Test
    public void testIsFull_WhenNoSitesOpened() {
        Percolation percolation = new Percolation(5);
        assertFalse("Site should not be full when no sites are opened", percolation.isFull(2, 3));
        assertFalse("Site should not be open when no sites are opened", percolation.isOpen(2, 3));
    }


    @Test
    public void testIsFull_ConsistencyWithIsOpen() {
        Percolation percolation = new Percolation(5);
        percolation.open(2, 3);
        assertTrue("Site should be open after opening", percolation.isOpen(2, 3));
        assertFalse("Site should not be full if not connected to the top", percolation.isFull(2, 3));
    }

    @Test
    public void testSiteBecomesFullWhenConnectedToTop() {
        Percolation percolation = new Percolation(5);
        percolation.open(1, 3); // Open top row site
        percolation.open(2, 3); // Open next row site directly below the first
        assertTrue("Site (2,3) should be full when connected to an open site in the top row", percolation.isFull(2, 3));
    }

    @Test
    public void testPercolationForN2AdditionalCases() {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 2);
        percolation.open(2, 2);
        assertTrue("Should percolate after opening top-right and bottom-right sites", percolation.percolates());

        Percolation percolation2 = new Percolation(2);
        percolation2.open(1, 1);
        percolation2.open(1, 2);
        assertFalse("Should not percolate after opening only top row sites", percolation2.percolates());
    }

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
