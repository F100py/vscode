package Stackthings;

import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.*;

public class IntQueueTest {
    private IntQueue queue;

    @Before
    public void setUp() {
        queue = new IntQueue(new LinkedList<Integer>());
    }

    @Test
    public void testAdd() {
        queue.add(1);
        queue.add(2);
        assertEquals(2, queue._list.size());
    }

    @Test
    public void testRemove() {
        queue.add(1);
        queue.add(2);
        int removed = queue.remove();
        assertEquals(1, removed);
        assertEquals(1, queue._list.size());
    }

    @Test
    public void testPeek() {
        queue.add(1);
        queue.add(2);
        int peeked = queue.peek();
        assertEquals(1, peeked);
        assertEquals(2, queue._list.size());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testRemoveEmpty() {
        queue.remove();
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testPeekEmpty() {
        queue.peek();
    }
}
