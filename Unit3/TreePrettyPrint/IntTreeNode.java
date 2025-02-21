package Unit3.TreePrettyPrint;

public class IntTreeNode {
    int data;
    IntTreeNode left;
    IntTreeNode right;
    int distLeft = 0;

    public IntTreeNode(int data){
        this.data = data;
    }
    public IntTreeNode(int data, IntTreeNode left, IntTreeNode right){
        this.data = data;
        this.left = left;
        this.right= right;
    }
}
