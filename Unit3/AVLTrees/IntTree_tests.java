package Unit3.AVLTrees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntTree_tests {

    private IntTree newTree(int... values) {
        IntTree tree = new IntTree();
        for(int data : values) {
            tree.addValue(data);
        }
        return tree;
    }

    @Test
    public void test_bstTree() {
        IntTree tree = newTree(1,2,3,4,5,6);
        String expected = 
        "[1]               \n" +
        "   \\              \n" +
        "   [2]            \n" +
        "      \\           \n" +
        "      [3]         \n" +
        "         \\        \n" +
        "         [4]      \n" +
        "            \\     \n" +
        "            [5]   \n" +
        "               \\  \n" +
        "               [6]\n" +
        "                  \n";
        String output = tree.toPrettyPrint();
        System.out.println(output);
        assertEquals(expected, output);
    }

    private IntTree newTreeAVL(int... values) {
        IntTree tree = new IntTree();
        for(int data : values) {
            tree.addValueAVL(data);
        }
        return tree;
    }

    @Test
    public void test_bstTreeAVL() {
        IntTree tree = newTreeAVL(1,2,3,4,5,6);
        String expected = 
        "[1]               \n" +
        "   \\              \n" +
        "   [2]            \n" +
        "      \\           \n" +
        "      [3]         \n" +
        "         \\        \n" +
        "         [4]      \n" +
        "            \\     \n" +
        "            [5]   \n" +
        "               \\  \n" +
        "               [6]\n" +
        "                  \n";
        String output = tree.toPrettyPrint();
        System.out.println(output);
        assertEquals(expected, output);
    }
}
