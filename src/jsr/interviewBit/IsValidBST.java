package jsr.interviewBit;

public class IsValidBST {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

    public static int isValidBST(TreeNode A) {
        return isValidBST(A, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static  int isValidBST(TreeNode A, int max, int min){
        if(A == null){
            return 1;
        }
        if(A.val>max || A.val<min){
            return 0;
        }
        if(isValidBST(A.right, max, Math.max(min, A.val)) == 0){
            return 0;
        }
        if(isValidBST(A.left, Math.min(A.val, max), min) == 0){
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(11);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        isValidBST(node1);
    }



}
