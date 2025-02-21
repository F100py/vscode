package Stackthings;

import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.*;

public class IntStackTest {
    private IntStack stack;

    @Before
    public void setUp() {
        stack = new IntStack(new LinkedList<Integer>());
    }

    @Test
    public void testEmpty() {
        assertTrue(stack.empty());
        stack.push(1);
        assertFalse(stack.empty());
    }

    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        int popped = stack.pop();
        assertEquals(2, popped);
        assertEquals(1, stack.peek());
    }

    @Test
    public void testPush() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    public void testSearch() {
        stack.push(1);
        stack.push(2);
        assertEquals(0, stack.search(1));
        assertEquals(1, stack.search(2));
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testPopEmpty() {
        stack.pop();
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testPeekEmpty() {
        stack.peek();
    }
}
