package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaxProd {
	
	static public class Nums implements Comparable<Nums>{

		int ele;
		int index;
		
		public Nums(int ele,int index){
			this.ele = ele;
			this.index = index;
		}
	
		@Override
		public int compareTo(Nums num) {
			// TODO Auto-generated method stub
			return this.ele-num.ele;
		}
		@Override
		public String toString(){
			return "["+ele+","+index+"]";
			
		}
		
	}

	static public int maxSpecialProduct(List<Integer> A) {
		int max = 0;
		
		
		
		Stack<Integer> lStack = new Stack<Integer>();
		Stack<Integer> rStack = new Stack<Integer>();
		Integer[] lsp = new Integer[A.size()];
		Integer[] rsp = new Integer[A.size()];
		
		for(int i=0;i<A.size();i++){
			if(lStack.isEmpty()){
				lStack.push(i);
				lsp[i] = 0;
				continue;
			}
			while(!lStack.isEmpty() && A.get(lStack.peek()) <= A.get(i))
				lStack.pop();
			if(lStack.isEmpty())
				lsp[i]=0;
			else
				lsp[i] = lStack.peek();
			lStack.push(i);
		}
		
		for(int i=A.size()-1;i>=0;i--){
			if(rStack.isEmpty()){
				rStack.push(i);
				rsp[i] = 0;
				continue;
			}
			while(!rStack.isEmpty() && A.get(rStack.peek()) <= A.get(i))
				rStack.pop();
			if(rStack.isEmpty())
				rsp[i]=0;
			else
				rsp[i] = rStack.peek();
			rStack.push(i);
		}
		for(int i=0;i<lsp.length;i++){
			max = Math.max(max, (lsp[i]*rsp[i])%1000000007);
		}
		return max;
		
		/*List<Nums> numbers = new ArrayList<Nums>();
		for(int i=0;i<A.size();i++){
			Nums num = new Nums(A.get(i),i);
			numbers.add(num);
		}
		Collections.sort(numbers);
		
		System.out.println(numbers);
		
		for(int i=0;i<numbers.size();i++){
			int ls=Integer.MIN_VALUE,rs=Integer.MAX_VALUE;
			for(int j=i+1;j<numbers.size();j++){
				if(numbers.get(i).ele!=numbers.get(j).ele){
					if(numbers.get(j).index<numbers.get(i).index && numbers.get(j).index>ls)
						ls = numbers.get(j).index;
					if(numbers.get(j).index>numbers.get(i).index && numbers.get(j).index<rs)
						rs = numbers.get(j).index;
				}
			}
			if(ls!=Integer.MIN_VALUE && rs!=Integer.MAX_VALUE)
				max = Math.max(max, (ls*rs)%1000000007);
		}

		for (int i = 1; i < A.size() - 1; i++) {
			int ls = leftSpecial(A, i);
			int rs = rightSpecial(A, i);
			max = Math.max(max, (ls * rs) % 1000000007);
		}

		return max;*/
	}

	private static int leftSpecial(List<Integer> a, int i) {		
		int ele = a.get(i);
		int ls = 0;
		for (int j = i - 1; j >= 0; j--) {
			if (a.get(j) > ele) {
				ls = j;
				break;
			}
		}
		return ls;
	}

	private static int rightSpecial(List<Integer> a, int i) {		
		int rs = 0;
		int ele = a.get(i);
		for (int j = i + 1; j < a.size(); j++) {
			if (a.get(j) > ele) {
				rs = j;
				break;
			}

		}

		return rs;
	}

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9);
		System.out.println(maxSpecialProduct(A));
	}

}
