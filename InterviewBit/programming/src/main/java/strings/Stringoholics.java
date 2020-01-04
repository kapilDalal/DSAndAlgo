package strings;

import java.util.ArrayList;

public class Stringoholics {
	
	public int solve(ArrayList<String> A) {
		long res = 1;		
		for(int i=0;i<A.size();i++){
			
			long cnt = getRotations(A.get(i));
			res = lcm(res,cnt);
			
		}
		
		return (int) res;
    }

	long gcd(long a, long b){ 
	    if (a == 0) 
	        return b;  
	    return (gcd(b % a, a));  
	 } 
	  
	   
	// Function to return LCM of two numbers  
	 long lcm(long a, long b)  
	 {  
	    return ((a*b)/gcd(a, b));  
	 }  
	
	private long getRotations(String str) {
		// TODO Auto-generated method stub
		
		StringBuilder s = new StringBuilder(str);
		
		int i=1;
		long ret = 1;
		String s1 = str.substring(0, 1);
		s = new StringBuilder(s.substring(1, s.length()));
		String res = s+s1;
		
		while(!str.equals(res)){
			i = (i+1)%str.length();
			/*if(i==0)
				i++;*/
			ret = (ret+1)%1000000007;
			s1 = res.substring(0, i);
			s = new StringBuilder(res.substring(i, res.length()));
			res = s+s1;
		}
		
		
		return ret;
	}
	
	public static void main(String[] args) {
		
		Stringoholics sh = new Stringoholics();
		ArrayList<String> A  = new ArrayList<>();
		A.add("ab");
		A.add("ababa");
		A.add("aba");
		
		System.out.println(sh.solve(A));
	}

}
