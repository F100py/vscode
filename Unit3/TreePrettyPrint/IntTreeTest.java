package Unit3.TreePrettyPrint;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IntTreeTest {

    @Test
    public void testInOrderTraversal() {
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        IntTree tree = new IntTree(values);
        String expected = "2, 3, 4, 5, 6, 7, 8, ";
        assertEquals("In-order traversal failed.", expected, tree.toInOrderString());
    }

    @Test
    public void testPostOrderTraversal() {
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        IntTree tree = new IntTree(values);
        String expected = "2, 4, 3, 6, 8, 7, 5, ";
        assertEquals("Post-order traversal failed.", expected, tree.toPostOrderString());
    }

    @Test
    public void testPreOrderTraversal() {
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        IntTree tree = new IntTree(values);
        String expected = "5, 3, 2, 4, 7, 6, 8, ";
        assertEquals("Pre-order traversal failed.", expected, tree.toPreOrderString());
    }
}
