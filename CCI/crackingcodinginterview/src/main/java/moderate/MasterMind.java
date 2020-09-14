package moderate;

import java.util.HashMap;

public class MasterMind {
    public String masterMind(String actual, String guess) {

        int a = 0;
        int b = 0;
        String res = "";
        String unmatched = "";
        int i=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(;i<actual.length();i++){
            if(actual.charAt(i)==guess.charAt(i)){
                a++;
            }else{
                map.put(actual.charAt(i),map.getOrDefault(actual.charAt(i),0)+1);
                unmatched += guess.charAt(i);
            }
        }
        //unmatched += guess.substring(i,guess.length());

        for(int j=0;j<unmatched.length();j++){
            Character ch = unmatched.charAt(j);
            if(map.containsKey(ch)){
                b++;
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    int val = map.get(ch);
                    map.put(ch,val-1);
                }
            }
        }
        res += a +"H"+b+"Ph";
        return res;
    }

}
