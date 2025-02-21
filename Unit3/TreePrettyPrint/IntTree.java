package Unit3.TreePrettyPrint;

public class IntTree {

    public static void main(String args[]){
        // System.out.println(new IntTree(new int[]{2,1}).toPrettyPrint());
    }
    IntTreeNode overallRoot;
    public IntTree(){
        overallRoot = null;
    }
    public IntTree(int[] nums){
        overallRoot = new IntTreeNode(nums[0]);
        for (int i = 1; i<nums.length; i++){
            addValue(nums[i]);
        }
    }
    public void addValue(int num){
        boolean added = false;
        IntTreeNode temp = overallRoot;
        while(!added){
            if(num<temp.data){
                if(temp.left==null){
                    temp.left = new IntTreeNode(num);
                    added = true;
                }else{
                    temp = temp.left;
                }
            } else {
                if(temp.right==null){
                    temp.right = new IntTreeNode(num);
                    added = true;
                }else{
                    temp = temp.right;
                }
            }
        }
    }

    public String toInOrderString(){
        return inOrderHelper(overallRoot);
    }
    private String inOrderHelper(IntTreeNode root){
        if(root==null)
            return "";
        String ans = inOrderHelper(root.left) + root.data + ", " + inOrderHelper(root.right);
        return ans;
    }

    public String toPostOrderString(){
        return postOrderHelper(overallRoot);
    }
    private String postOrderHelper(IntTreeNode root){
        if(root==null)
            return "";
        String ans = postOrderHelper(root.left) + postOrderHelper(root.right) + root.data + ", ";
        return ans;
    }

    public String toPreOrderString(){
        return preOrderHelper(overallRoot);
    }
    private String preOrderHelper(IntTreeNode root){
        if(root==null)
            return "";
        String ans = root.data+", " + preOrderHelper(root.left) + preOrderHelper(root.right);
        return ans;
    }

    public int getHeight(IntTreeNode root){
        if(root!=null)
            return 1+ Math.max(getHeight(root.left),getHeight(root.right));
        else
            return 0;
    }
    int curlevel = 0;
    String[][] pretty;
    public String toPrettyPrint(){
        pretty = new String[getHeight(overallRoot)*2+1][countNodes(overallRoot)+1];
        for (int i = 0; i < pretty.length; i++) {
            for (int j = 0; j < pretty[i].length; j++) {
                pretty[i][j] = "   ";
            }
        }
        pretty[curlevel*2][countNodes(overallRoot.left)] = "["+overallRoot.data+"]";
        pretty[curlevel*2+1][countNodes(overallRoot.left.left)] = "  /";
        for(int i = countNodes(overallRoot.left.left)+1; i<countNodes(overallRoot.left.left)+countNodes(overallRoot.left.right)+1; i++){
            pretty[curlevel*2][i] += "___";
        }
        pretty[curlevel*2+1][countNodes(overallRoot.right.left)+1+countNodes(overallRoot.left)] = "\\  ";
        for(int i = countNodes(overallRoot.left); i<countNodes(overallRoot.left)+countNodes(overallRoot.right.left); i++)              
            pretty[curlevel*2][i] += "___";
        prettyHelper(overallRoot, 0);
        

        String ans = "";
        for (int i = 0; i < pretty.length; i++) {
            for (int j = 0; j < pretty[i].length; j++) {
                ans += pretty[i][j];
            }
            ans+="\n";
        }
        return ans;
    }
    private void prettyHelper(IntTreeNode root, int curlevel){
        buildLeft(root.left, curlevel+1);
        buildRight(root.right, curlevel+1);
    }
    private void buildLeft(IntTreeNode root, int curlevel){
        if(root!=null){
                pretty[curlevel*2][countNodes(root.left)] = "["+root.data+"]";
            if(root.left!=null){
                for(int i = countNodes(root.left.left); i<countNodes(root.left.left)+countNodes(root.left.right); i++){
                    if (i==countNodes(root.left.left))
                        pretty[curlevel*2+1][i] = "/";
                    else
                        pretty[curlevel*2][i] = "___";
                }
            }
            prettyHelper(root, curlevel);
        }      
    }
    private void buildRight(IntTreeNode root, int curlevel){
        if(root!=null){
                pretty[curlevel*2][countNodes(overallRoot)-countNodes(root.right)-1] = "["+root.data+"]";
            if(root.right!=null){
                for (int i = countNodes(overallRoot)-countNodes(root.right); i<countNodes(root.right.left)+countNodes(overallRoot)-countNodes(root.right); i++){
                    pretty[curlevel*2][i] = "___";
                }
            }
            prettyHelper(root, curlevel);
        }

    }
    public int countNodes(IntTreeNode root){
        if(root==null)
            return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
