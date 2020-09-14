package challenge.monthly.september;

import java.util.ArrayList;

public class SumRootToLeaf_8 {
    
      
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; left=null;right=null;}
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public int sumRootToLeaf(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int sum = 0;
        generateBinaries(root,res,new ArrayList<Integer>());
        for(int i=0;i<res.size();i++){
            ArrayList<Integer> l = res.get(i);
            sum += getNumber(l);
        }
        return sum;
    }

    private void generateBinaries(TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> l)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null) {
            ArrayList<Integer> l1 = new ArrayList<>(l);
            l1.add(root.val);
            res.add(l1);
            return;
        }
        l.add(root.val);
        generateBinaries(root.left,res,new ArrayList<>(l));
        generateBinaries(root.right,res,new ArrayList<>(l));
    }

    private int getNumber(ArrayList<Integer> l) {
          int num = 0;
          for(int i=l.size()-1;i>=0;i--){
              num += l.get(i)*Math.pow(2,l.size()-1-i);
          }
          return num;
    }

    public static void main(String[] args) {
        SumRootToLeaf_8 s = new SumRootToLeaf_8();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        //root.right = new TreeNode(1);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        //root.right.left = new TreeNode(0);
        //root.right.right = new TreeNode(1);
        System.out.println(s.sumRootToLeaf(root));
    }

}
