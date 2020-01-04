package strings;

public class ValidNumber {
	
	public int isNumber(final String A) {
		
				
		boolean exp = false;
		int len = 0;
		if(A.contains("."))
			len = A.split("\\.").length;
		if(len>2 || len==1)
			return 0;
		int j = 0;
		int k=A.length()-1;
		while (k >=0 && A.charAt(k) == ' ') {
			k--;
		}
		while (j < A.length() && A.charAt(j) == ' ') {
			j++;
		}		
		if(A.length()==j)
			return 0;
		for (int i = j; i <= k; i++) {
			char ch = A.charAt(i);
			if(ch=='+' && i==0)
				continue;
			if (ch == '-' && i==0) {				
				continue;
			}
			if (ch=='-' || ch=='.' || ch=='e' || (ch - '0' >= 0 && ch - '0' <= 9)) {
				if(ch=='.'){
					if(exp || i+1<A.length() && A.charAt(i+1)=='e')
						return 0;
				}
				else if(ch=='e'){
					exp = true;
					continue;
				}
				else if(ch=='-' && i-1>0 && A.charAt(i-1)!='e')
					return 0;
			} else
				return 0;
		}
		
		return 1;
    }
	
	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber("-01.1e-10  "));
		
	}

}
