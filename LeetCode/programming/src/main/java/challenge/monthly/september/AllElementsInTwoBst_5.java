package challenge.monthly.september;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBst_5 {

    
     
      public class TreeNode {
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

    private void store(TreeNode node,ArrayList<Integer> l){
          if(node==null)
              return;
          store(node.left,l);
          if(node!=null)
              l.add(node.val);
          store(node.right,l);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        store(root1,l1);
        ArrayList<Integer> l2 = new ArrayList<>();
        store(root2,l2);
        ArrayList<Integer> res = new ArrayList<>();
        int f = 0;
        int s = 0;
        while(f<l1.size() && s<l2.size()){
            if(l1.get(f)<l2.get(s)){
                res.add(l1.get(f));
                f++;
            }else{
                res.add(l2.get(s));
                s++;
            }
        }
        if(f<l1.size())
            res.addAll(l1.subList(f,l1.size()));
        if(s<l2.size())
            res.addAll(l2.subList(s,l2.size()));

        return res;
    }

}
