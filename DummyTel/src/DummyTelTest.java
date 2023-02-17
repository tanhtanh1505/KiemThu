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
     * Test invalid time.
     */
    @Test
    public void testInvalidTime() {
        try {
            tel.calc(12, -1, 60);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
            assertEquals(DummyTel.TIME_INVALID, anIllegalArgumentException.getMessage());
        }

        try {
            tel.calc(12, 60, 60);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
            assertEquals(DummyTel.TIME_INVALID, anIllegalArgumentException.getMessage());
        }

        try {
            tel.calc(-1, 30, 60);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
            assertEquals(DummyTel.TIME_INVALID, anIllegalArgumentException.getMessage());
        }

        try {
            tel.calc(24, 30, 60);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
            assertEquals(DummyTel.TIME_INVALID, anIllegalArgumentException.getMessage());
        }
    }

    /**
     * Test invalid calling.
     */
    @Test
    public void testInvalidCalling() {
        try {
            tel.calc(12, 30, -1);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
            assertEquals(DummyTel.MINUS_CALLING_INVALID, anIllegalArgumentException.getMessage());
        }
    }

    /**
     * Test calc.
     */
    @Test
    public void testCalc() {
        assertEquals(15.75, tel.calc(7, 59, 60));
        assertEquals(12.01, tel.calc(7, 59, 61));
        assertEquals(31.5, tel.calc(8, 0, 60));
        assertEquals(24.02, tel.calc(8, 0, 61));

        assertEquals(31.5, tel.calc(17, 59, 60));
        assertEquals(24.02, tel.calc(17, 59, 61));
        assertEquals(15.75, tel.calc(18, 0, 60));
        assertEquals(12.01, tel.calc(18, 0, 61));

        assertEquals(15.75, tel.calc(13, 30, 30));
        assertEquals(7.88, tel.calc(1, 30, 30));
    }

    /**
     * Tear down
     */
    public void tearDown() {
        tel = null;
    }

}
