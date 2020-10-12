package challenge.monthly.october;

import java.util.ArrayList;

public class SerializeDeserializeBst_9 {


      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public String serialize(TreeNode root) {
        ArrayList<Character> res = new ArrayList<>();
        sUtil(root,res);
        String r = "";
        for(int i=0;i<res.size();i++)
            r = r+res.get(i);
        return r;
    }
    private void sUtil(TreeNode root,ArrayList<Character> str){
        if(root==null)
            return;
        str.add((char) (root.val+48));
        sUtil(root.left,str);
        sUtil(root.right,str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        for(int i=0;i<data.length();i++)
            root = insert(root,(int)data.charAt(i));
        return root;
    }

    private TreeNode insert(TreeNode root,int num){
        if(root==null)
            return new TreeNode(num);
        else if(root.val<num)
            root.right = insert(root.right,num);
        else
            root.left = insert(root.left,num);
        return root;

    }

    public static void main(String[] args) {
        SerializeDeserializeBst_9 sd = new SerializeDeserializeBst_9();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String s = sd.serialize(root);
        System.out.println(s);


    }

}
