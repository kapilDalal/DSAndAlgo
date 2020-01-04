package strings;

import java.util.ArrayList;

public class MultiplyStrings {
	
	
	public String multiply(String A, String B) {
		String res = "";
		ArrayList<String> l = new ArrayList<>();
		int zerosToAppend = 0;
		for(int i=B.length()-1;i>=0;i--){
			String mulRes = mul(A,B.charAt(i));
			if(zerosToAppend!=0){
				for(int j=1;j<=zerosToAppend;j++)
					mulRes = mulRes + "0";
			}			
			zerosToAppend++;
			l.add(mulRes);			
		}
		for(int i=0;i<l.size();i++){
			res = add(res,l.get(i));
		}
		
		StringBuffer buf = new StringBuffer(res);
		while(buf.length()>1 && buf.charAt(0)=='0')
			buf.deleteCharAt(0);				
		return buf.toString();
    }

	private String add(String S1, String S2) {
		String res = "";
		int s1 = S1.length()-1;
		int s2 = S2.length()-1;
		int c = 0;
		while(s1>=0 && s2>=0){
			int f = S1.charAt(s1) - '0';
			int s = S2.charAt(s2) - '0';
			int r = f + s + c;
			c = r / 10;
			r = r % 10;
			res = String.valueOf(r) + res;
			s1--;
			s2--;
		}
		while(s1>=0){
			int f = S1.charAt(s1) - '0';
			int r = f + c;
			c = r / 10;
			r = r % 10;
			res = String.valueOf(r) + res;
			s1--;
		}
		while(s2>=0){
			int s = S2.charAt(s2) - '0';
			int r = s + c;
			c = r / 10;
			r = r % 10;
			res = String.valueOf(r) + res;
			s2--;
		}
		if(c!=0)
			res = String.valueOf(c) + res;
		return res;
	}

	private String mul(String s, char ch) {
		StringBuffer res = new StringBuffer();
		int num = ch - '0';
		int carry = 0;
		
		for(int i=s.length()-1;i>=0;i--){
			int num1 = s.charAt(i) - '0';
			int r = num1 * num + carry;
			carry = r/10;
			r = r % 10;
			res.append(r);
		}
		if(carry!=0)
			res.append(carry);
		res = res.reverse();		
		return res.toString();
	}
	public static void main(String[] args) {
		MultiplyStrings ms = new MultiplyStrings();
		System.out.println(ms.multiply("12", "0"));
	}

}
