package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Letterphone {
	
	static public ArrayList<String> letterCombinations(String A) {
        HashMap<Character,String> map = new HashMap<Character,String>();
        map.put('0',"0");
        map.put('1',"1");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        ArrayList<String> res = new ArrayList<String>(Arrays.asList(""));
        if(A.length()==0)
        	return res;        
        //System.out.println(A);
        for(int i=0;i<A.length();i++){
            Character ch = A.charAt(i);
            String str = map.get(ch);
            ArrayList<String> res1 = new ArrayList<String>();
            for(int j=0;j<res.size();j++){
                String resStr = res.get(j);
                for(int k=0;k<str.length();k++){
                     res1.add(resStr+String.valueOf(str.charAt(k)));      
                }
            }
            res = res1;
        }
        return res;
    }
	public static void main(String[] args) {
		letterCombinations("435");
	}

}
