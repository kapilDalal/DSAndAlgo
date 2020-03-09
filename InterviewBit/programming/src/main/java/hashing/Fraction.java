package hashing;

import java.util.Iterator;
import java.util.TreeSet;

public class Fraction {
	
	static public String fractionToDecimal(int A, int B) {
		String res = "";
		if(A<B)
			res = res + "0";
		else{
			int q = A/B;
			A = A%B;
			res = res + String.valueOf(q);		
			if(A==0)
				return res;
		}			
		TreeSet<String> set = new TreeSet<>();
		res = res + ".";
		boolean stayInLoop = true;
		while(stayInLoop){
			A = A*10;
			int q = A/B;
			A = A%B;
			if(A==0){
				res = res + String.valueOf(q);
				return res;
			}
			if(set.isEmpty()){
				set.add(String.valueOf(q));
				res = res + String.valueOf(q);
				continue;
			}
			if(set.contains(String.valueOf(q)) && repeating(A,B,set,q)){
				String[] split = res.split("\\.");
				split[0] = split[0]+".(";
				split[1] = split[1]+")";
				res = split[0] + split[1];
				return res;
			}else{				
				String str = set.last().concat(String.valueOf(q));
				res = res + String.valueOf(q);
				set.add(str);				
			}
		}
		return res;		
    }

	static private boolean repeating(int a, int b, TreeSet<String> set,int q) {
		// TODO Auto-generated method stub
		Iterator<String> iterator = set.iterator();
		if(set.size()==1){
			if(set.contains(String.valueOf(q)))
				return true;
			return false;
		}
			
		String res = "" + String.valueOf(q);
		String next = iterator.next();
		if(next.compareTo(String.valueOf(q))!=0)
			return false;
		while(iterator.hasNext()){
			next = iterator.next();
			a = a * 10;
			int q1 = a/b;
			a = a % b;			
			res = res + String.valueOf(q1);
			if(!set.contains(res))
				return false;
			
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(fractionToDecimal(2, 3));
		
	}
}
