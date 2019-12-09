package strings;

public class PalindromeString {
	static public int isPalindrome(String A) {
		int res = 1;
		int i = 0;
		int j = A.length()-1;
		A = A.toLowerCase();
		while(i<j){
			char chI = A.charAt(i);
			char chJ = A.charAt(j);
			if(Character.isDigit(chI) || Character.isDigit(chJ))
				return 0;
			if(!Character.isAlphabetic(chI)){
				i++;
				continue;
			}
			if(!Character.isAlphabetic(chJ)){
				j--;
				continue;
			}
			
			if(Character.toLowerCase(chI)!=Character.toLowerCase(chJ))
				return 0;
			i++;
			j--;
		}
				
		return res;
    }
	public static void main(String[] args) {
		String str = "race a ecar";
		System.out.println(isPalindrome(str));
	}
}
