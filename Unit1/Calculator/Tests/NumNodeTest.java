package Calculator.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import Calculator.NumNode;
public class NumNodeTest {
    @Test
    public void testConstructor(){
        NumNode n = new NumNode("69");
        assertEquals(69.0, n.getNum());
    }
}
