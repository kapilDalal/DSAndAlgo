package challenge.monthly.september;

import java.util.HashMap;

public class WordPattern_7 {

    public static boolean wordPattern(String pattern, String str) {

        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Character> map1 = new HashMap<>();
        String[] s = str.split(" ");
        if(s.length!=pattern.length())
            return false;

        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String st = s[i];
            if(map.containsKey(ch) && !map.get(ch).equals(st)){
                return false;
            }
            if(map1.containsKey(st) && map1.get(st)!=ch)
                return false;
            map.put(ch,st);
            map1.put(st,ch);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("aaa","aa aa aa aa"));

    }


}
