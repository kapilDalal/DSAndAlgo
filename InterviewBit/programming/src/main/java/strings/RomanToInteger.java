package strings;

import java.util.HashMap;

public class RomanToInteger {
	
	HashMap<Character,Integer> map = null;

    public void init(){
        map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }
    public int romanToInt(String A) {
        init();
        int res = 0;
        
        StringBuffer str = new StringBuffer(A);
        for(int i=0;i<str.length();){
        	Character ch = str.charAt(i);
        	if(!map.containsKey(ch)){
        		str.deleteCharAt(i);
        		continue;
        	}
        	i++;
        }
        A = str.toString();
        
        res = res + map.get(A.charAt(A.length()-1));
        for(int i=A.length()-2;i>=0;i--){
           
            if(map.get(A.charAt(i))<map.get(A.charAt(i+1))){
                res = res - map.get(A.charAt(i));
            }else{
                res = res + map.get(A.charAt(i));
            }
            
        }
        return res;
        
    }
    
    public static void main(String[] args) {
		RomanToInteger ri = new RomanToInteger();
		;
		System.out.println(ri.romanToInt("XANKURM"));
	}

}
