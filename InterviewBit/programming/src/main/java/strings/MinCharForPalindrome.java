package strings;

public class MinCharForPalindrome {
	
	public int solve(String A) {
		int res = 1;
		
		for(int i=A.length()-1;i>=0;i--){
			if(isPalindroic(A,i)){
				res = i;
				break;
			}				
		}
		
		return A.length()-(res+1);
    }
	private boolean isPalindroic(String a, int i) {
		int start = 0;
		int end = i;
		while(start<end){
			if(a.charAt(start)!=a.charAt(end))
				return false;
			start++;
			end--;			
		}
		return true;
	}
	public static void main(String[] args) {
		MinCharForPalindrome mp = new MinCharForPalindrome();
		System.out.println(mp.solve("banana"));
	}

}
