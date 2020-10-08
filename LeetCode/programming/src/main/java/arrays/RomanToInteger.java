package arrays;

import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        HashMap<String, Integer> map1= new HashMap<>();
        map1.put("IV",4);
        map1.put("IX",9);
        map1.put("XL",40);
        map1.put("XC",90);
        map1.put("CD",400);
        map1.put("CM",900);

        int i=s.length()-1;
        int res = 0;
        while(i>=0){
            char c = s.charAt(i);
            String str = "";
            if(i-1>=0){
                str = String.valueOf(s.charAt(i-1)) + c;
            }
            if(map1.containsKey(str)){
                res += map1.get(str);
                i--;
            }
            else{
                res += map.get(c);
            }
            i--;
        }
        return res;
    }

    public static void main(String[] args) {
        RomanToInteger ri = new RomanToInteger();
        System.out.println(ri.romanToInt("IXLDMCV"));
    }


}
