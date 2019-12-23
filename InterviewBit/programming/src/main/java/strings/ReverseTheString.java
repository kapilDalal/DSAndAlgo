package strings;

public class ReverseTheString {
	static public String solve(String A) {
		String res = "";
		String[] split = A.split(" ");
		/*for( int i=split.length-1;i>=0;i--)
			res = res + split[i]+" ";*/
		char[] charArray = A.toCharArray();
		
		char[] rev = new char[charArray.length];
		
		for(int i=charArray.length-1;i>=0;i--)
			rev[charArray.length-1-i] = charArray[i];
		
		int i=0;		
		while(i<rev.length){
			if(rev[i]!=' '){
				int j = reverse(rev,i);
				i=i+j;
			}
			else
			 i++;
		}
		for(int j=0;j<rev.length;j++)
			res = res + rev[j];
		return res;
    }
	private static int reverse(char[] rev, int i) {
		// TODO Auto-generated method stub
		int j=i;
		while(j<rev.length && rev[j]!=' ')
			j++;
		int next = j--;
		int start = i;
		while(i<j){
			char temp = rev[j];
			rev[j] = rev[i];
			rev[i] = temp;
			i++;
			j--;
		}
		return next-start;
	}
	public static void main(String[] args) {
		System.out.println(solve(" j "));
	}
}
