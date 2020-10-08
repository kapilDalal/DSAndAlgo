package challenge.weekly.October4;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {

    
      //Definition for a binary tree node.
      static public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    public boolean isEvenOddTree(TreeNode root)
    {
        if(root.val%2==0)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int last = -1;

            while(size>0){
                TreeNode node = q.poll();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);

                if(level%2==0){
                    if(last!=-1)
                    {
                        if(node.val%2==0 || node.val<=last)
                            return false;
                    }else{
                        if(node.val%2==0)
                            return false;
                    }
                }
                else{
                    if(last!=-1)
                    {
                        if(node.val%2!=0 || node.val>=last)
                            return false;
                    }
                    else{
                        if(node.val%2!=0)
                            return false;
                    }
                }

                last = node.val;
                size--;
            }


            level++;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);


        EvenOddTree eo  = new EvenOddTree();
        System.out.println(eo.isEvenOddTree(root));
    }

}
