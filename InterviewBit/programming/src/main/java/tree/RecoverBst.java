package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import tree.IsSymmetric.TreeNode;

public class RecoverBst {
	
	public ArrayList<Integer> recoverTree(TreeNode A) {
		ArrayList<Integer> l = new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        inorder(A,l);
        //System.out.println(l);
        if(l.size()<2)
            return res;
        for(int i=0;i<l.size()-1;i++){
            if(l.get(i)>l.get(i+1) && res.size()!=2){
                res.add(l.get(i));    
                if(i+1<l.size())
                res.add(l.get(i+1));
            }
            else if(l.get(i)>l.get(i+1)){
                res.remove(res.size()-1);
                res.add(l.get(i+1));
            }
        }
        Collections.sort(res);
        return res;
    }

	private void inorder(TreeNode a, ArrayList<Integer> l) {
		// TODO Auto-generated method stub
		if(a==null)
			return;
		inorder(a.left, l);
		l.add(a.val);
		inorder(a.right, l);
	}
	
	//below is constant space solution(without recursion without stack)
	
	static TreeNode first,second;
	static TreeNode pre=null;
	
	static void morris(TreeNode node){
		if(node==null)
			return;
		TreeNode curr = node;
		while(curr!=null){
			if(curr.left==null){
				visit(curr);
				curr = curr.right;
			}
			else{
				TreeNode prev = curr.left;
				while(prev.right!=null && prev.right!=curr)
					prev = prev.right;
				if(prev.right==null){
					prev.right = curr;
					curr = curr.left;
				}else{
					visit(curr);
					prev.right = null;
					curr = curr.right;
				}
			}
		}
	}
	
	
	
	private static void visit(TreeNode curr) {
		// TODO Auto-generated method stub
		if(pre!=null && pre.val>curr.val){
			if(first==null)
				first = pre;
			else
				second = pre;
		}
		pre = curr;
	}

	public static void main(String[] args) {
		RecoverBst rb = new RecoverBst();
		rb.recoverTree(null);
	}

}
