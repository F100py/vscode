package Calculator.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Calculator.RawNode;

public class RawNodeTest {
    @Test
    public void testConstruct(){
        RawNode n = new RawNode("wsup");
        assertEquals("wsup", n.getRawContent());
        assertEquals(null, n.getNext());
        assertEquals(null, n.getPrev());
    }
}
