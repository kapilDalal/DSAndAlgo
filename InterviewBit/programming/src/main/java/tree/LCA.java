package tree;

import java.util.ArrayList;

import tree.IsSymmetric.TreeNode;

public class LCA {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	public int lca(TreeNode A, int B, int C) {		
		ArrayList<Integer> l1 = null;
		ArrayList<Integer> l2 = null;
		findNode(A, B, new ArrayList<Integer>());
		findNode(A, C, new ArrayList<Integer>());
		System.out.println(res.size()+"\n");
		l1 = res.get(0);
		l2 = res.get(1);
		l1.retainAll(l2);
		return l1.get(l1.size()-1);
    }
	public void findNode(TreeNode A, int B, ArrayList<Integer> list){
        if(A==null)
            return;
        if(B==A.val){
            list.add(A.val);
            res.add(new ArrayList<Integer>(list));
            return;
        }
        list.add(A.val);
        findNode(A.left,B,new ArrayList<Integer>(list));
        findNode(A.right,B,new ArrayList<Integer>(list));
    }
	public static void main(String[] args) {
		TreeNode A = new TreeNode(10);
		A.left =new TreeNode(9);
		A.right = new TreeNode(20);
		LCA l = new LCA();
		System.out.println(l.lca(A, 9, 20));
	}

}
