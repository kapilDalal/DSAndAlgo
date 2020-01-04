package strings;

public class LongestPalindrome {
	
	
	public String longestPalindrome(String A) {
		String res = ""+String.valueOf(A.charAt(0));		
		for(int i=0;i<A.length()-1;i++){
			for(int j=A.length();j>=i;j--){
				
				//String sub = A.substring(i, j);
				if(isSubstring(A,i,j)){
					if((j-i)>res.length())
						res = A.substring(i, j);
				}
				
				
			}
		}		
		return res;
    }

	private boolean isSubstring(String sub, int i, int j) {
		// TODO Auto-generated method stub
		int start=i;
		int end = j-1;
		while(start<end){			
			if(sub.charAt(start)!=sub.charAt(end))
				return false;			
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		LongestPalindrome lp = new LongestPalindrome();
		
		System.out.println(lp.longestPalindrome("abb"));
	}

}
