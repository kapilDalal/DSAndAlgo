package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateGrayCode {
	
	public ArrayList<Integer> grayCode(int a) {
		
		ArrayList<Integer> res = new ArrayList<>();
		ArrayList<String> s = new ArrayList<>();
		if(a==0)
			return res;
		res.add(0);
		res.add(1);
		s.add("0");
		s.add("1");
		if(a==1)
			return res;
		res = new ArrayList<>();
		for(int i=2;i<=a;i++){
			s = new ArrayList<String>(reflectAndPrefix(s));
		}
		for(int i=0;i<s.size();i++){
			String str = s.get(i);
			int num = 0;			
			for(int j=str.length()-1;j>=0;j--){
				num =	(int) (num + (str.charAt(j)-'0') * Math.pow(2, str.length()-1-j));
			}
			res.add(num);
		}
		//System.out.println( res);
		return res;
    }

	private List<String> reflectAndPrefix(List<String> res) {
		// TODO Auto-generated method stub
		
		//reflect part
		for(int i=res.size()-1;i>=0;i--)
			res.add(res.get(i));				
		int end = res.size();
		
		//prefix part
		for(int i=0;i<end/2;i++){
			String str = res.get(i);
			str = "0" + str;
			res.add(str);
		}
		for(int i=end/2;i<end;i++){
			String str = res.get(i);
			str = "1" + str;
			res.add(str);
		}	
		return  res.subList(end, res.size());
	}
	public static void main(String[] args) {
		GenerateGrayCode gc = new GenerateGrayCode();		
		gc.grayCode(2);
		System.out.println(1<<3);
	}

}
