package challenge.monthly.september;

import java.io.BufferedReader;
import java.util.HashMap;

public class BullsAndCows_10 {

    public String getHint(String secret, String guess) {

        int a = 0;
        int b = 0;
        String res = "";
        String unmatched = "";
        int i=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                a++;
            }else{
                map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
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
        res += a +"A"+b+"B";
        return res;
    }

    public static void main(String[] args) {
        BullsAndCows_10 bc = new BullsAndCows_10();
        System.out.println(bc.getHint("","0111"));
    }


}
