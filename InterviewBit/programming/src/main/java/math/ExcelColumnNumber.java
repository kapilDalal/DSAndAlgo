package math;

public class ExcelColumnNumber {
	static public int titleToNumber(String A) {
		int res = 0;
		int n = A.length()-1;
		for(int i=0;i<A.length();i++){
			char ch = A.charAt(i);
			int mul = ch - 64;
			res = (int) (res + (mul * Math.pow(26, n-i)));
		}
		
		return res;
	}
	static public String numberToTitle(int A) {
		String str = "";
		while(A!=0){
			int ch = A%26;
			A = A/26;
			char[] c = Character.toChars(64+ch);
			if(c[0]=='@'){
				c[0]='Z';
				A--;
			}
			str = Character.toString(c[0])+str;
		}
		return str;
	}
	
	public static void main(String[] args) {
		
		System.out.println(numberToTitle(1));
		System.out.println(titleToNumber("AAZBKY"));
		//System.out.println(27/26);
	}

}
