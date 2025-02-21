package Unit0.School;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class CentralProcessingUnitTest {
    private CentralProcessingUnit a;
    @Before
    public void setup(){
        a = new CentralProcessingUnit(12,100,4,"AM4");
    }

    @Test
    public void testConstructorAndGetters(){
        assertEquals(12, a.getCores());
        assertEquals(100, a.getVolts());
        assertEquals(4, a.getFrequency());
        assertEquals("AM4", a.getSocketType());
    }

    @Test
    public void testUpgrade(){
        a.upgrade("cores");
        a.upgrade("volts");
        a.upgrade("frequency");
        assertEquals(16, a.getCores());
        assertEquals(105, a.getVolts());
        assertEquals(5, a.getFrequency());
    }

    public void testValid(){
        assertEquals(true, a.isValid());
        CentralProcessingUnit b = new CentralProcessingUnit(6, 60, 4, "Am4");
        assertEquals(false, b.isValid());
        CentralProcessingUnit c = new CentralProcessingUnit(16, 42, 4, "Am4");
        assertEquals(false, c.isValid());
        CentralProcessingUnit d = new CentralProcessingUnit(16, 60, 2, "Am4");
        assertEquals(false, d.isValid());
        CentralProcessingUnit e = new CentralProcessingUnit(16, 60, 4, "Am3");
        assertEquals(false, e.isValid());
    }
}
