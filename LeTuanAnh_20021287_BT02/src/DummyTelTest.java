import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * The class DummyTelTest.
 */
public class DummyTelTest extends TestCase {
    private DummyTel tel;

    @Before
    /** Set up the test fixture. */
    public void setUp() {
        tel = new DummyTel();
    }

    /**
     * Strong equivalence test.
     */
    @Test
    public void testStrongEquivalence() {
        assertEquals(7.88, tel.calc(7, 0, 30));
        assertEquals(20.08, tel.calc(7, 0, 90));
        assertEquals(15.75, tel.calc(10, 0, 30));
        assertEquals(40.16, tel.calc(10, 0, 90));
        assertEquals(7.88, tel.calc(20, 0, 30));
        assertEquals(20.08, tel.calc(20, 0, 90));
    }

    /**
     * Boundary value analysis test.
     */
    @Test
    public void testBoundaryValueAnalysis() {
        assertEquals(7.88, tel.calc(0, 30, 30));
        assertEquals(7.88, tel.calc(1, 30, 30));
        assertEquals(7.88, tel.calc(22, 30, 30));
        assertEquals(7.88, tel.calc(23, 30, 30));

        assertEquals(15.75, tel.calc(10, 0, 30));
        assertEquals(15.75, tel.calc(10, 1, 30));
        assertEquals(15.75, tel.calc(10, 58, 30));
        assertEquals(15.75, tel.calc(10, 59, 30));


        assertEquals(0.0, tel.calc(10, 30, 0));
        assertEquals(0.53, tel.calc(10, 30, 1));

        assertEquals(15.75, tel.calc(10, 30, 30));
    }

    /**
     * Tear down
     */
    public void tearDown() {
        tel = null;
    }

}
