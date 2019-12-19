package math;

public class PalindromeInteger {
	
	
	static public int isPalindrome(int A) {
        String str = "";
        while(A!=0){
        	int num = A %10;
        	A = A/10;
        	str = String.valueOf(num)+str;
        }
        System.out.println(str);
        
        int start = 0,end=str.length()-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end))
                return 0;
            start++;
            end--;
        }
        return 1;
    }
	
	public static void main(String[] args) {
		isPalindrome(1);
	}

}
