package stackAndqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NearestSmallerElement {

	static public ArrayList<Integer> prevSmaller(List<Integer> A) {
		ArrayList<Integer> res = new ArrayList<>();	
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<A.size();i++){
			int ele = A.get(i);
			while(!stack.isEmpty() && stack.peek()>=ele)
				stack.pop();
			if(stack.isEmpty())
				res.add(-1);
			else
				res.add(stack.peek());
			
			stack.push(ele);
			
		}
		System.out.println(res);
		
		
		return res;
	}
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(34,35,27,42,5,28,39,20,28);
		prevSmaller(list);
	}
}
