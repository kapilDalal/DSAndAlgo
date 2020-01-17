package hashing;

import java.util.HashSet;

public class ColorfulNumber {

	
	static public int colorful(int A) {
		
		String str = String.valueOf(A);
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<=str.length();i++){
			for(int j=0;j<str.length();j++){
				if(i+j<=str.length() && i+j>j){
					System.out.println(str.substring(j,i+j));
					int mul = mul(str.substring(j,i+j));
					/*if(set.contains(mul))
						return 0;
					set.add(mul);*/
				}
			}
		}
		
		
		return 1;
    }
	
	static public int colorfulOptimiesed(int a) {
        String A = Integer.toString(a);
        HashSet<Integer> set = new HashSet<Integer>();
        int prod = 0;
        for(int i = 0; i < A.length(); i++) {
            prod = 1;
            for(int j = i; j < A.length(); j++ ){
                prod *= A.charAt(j)-'0';   
                if(set.contains(prod))
                    return 0;
                else set.add(prod);    
            }
        }
        return 1; 
    }
	private static int mul(String str) {
		// TODO Auto-generated method stub
		if(str.length()==1)
			return Integer.parseInt(str);
		
		int res = 1;
		for(int i=0;i<str.length();i++)
			res *= str.charAt(i) - '0';
		
		return res;
	}
	public static void main(String[] args) {
		System.out.println(colorfulOptimiesed(3245));
	}
}
