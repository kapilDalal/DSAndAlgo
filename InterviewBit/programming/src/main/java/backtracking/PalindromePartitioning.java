package backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromePartitioning {

	public ArrayList<ArrayList<String>> partition(String a) {
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		Deque<String> dq = new LinkedList<>();
		partitionUtil(a,0,dq,res);
		System.out.println(res);
		return res;
	}

	private void partitionUtil(String str, int s, Deque<String> dq, ArrayList<ArrayList<String>> res) {
		if(s==str.length())
			res.add(new ArrayList<String>(dq));
		
		for(int i=s;i<str.length();i++){
			if(isPalindrome(str.substring(s,i+1))){
				dq.add(str.substring(s,i+1));
				partitionUtil(str, i+1, dq, res);
				dq.removeLast();
			}
		}
		
	}

	private boolean isPalindrome(String str) {
		// TODO Auto-generated method stub
		if(str.length()==1)
			return true;
		int start = 0;
		int end = str.length()-1;
		while(start<end){
			if(str.charAt(start)!=str.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		pp.partition("aab");
	}

}
