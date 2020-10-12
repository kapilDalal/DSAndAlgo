package challenge.weekly.October11;

import java.util.HashMap;

public class SplitStrings {

    public boolean checkPalindromeFormation(String a, String b) {



        HashMap<String,Boolean> map = new HashMap<>();
        for(int i=0;i<a.length();i++){
            String ap = a.substring(0,i);
            String as = a.substring(i);
            String bp = b.substring(0,i);
            String bs = b.substring(i);
            String f = ap+bs;
            String s = bp+as;
            if(map.containsKey(f)){
                if(map.get(f))
                    return true;
            }else{
                if(palin(f))
                    return true;
                map.put(f,false);
            }
            if(map.containsKey(s)){
                if(map.get(s))
                    return true;
            }else{
                if(palin(s))
                    return true;
                map.put(s,false);
            }

        }
        return false;
    }
    private boolean palin(String s){
        if(s.isEmpty() || s.length()==1)
            return true;
        int st = 0;
        int e = s.length()-1;
        while(st<e){
            if(s.charAt(st)!=s.charAt(e))
                return false;
            st++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {
        SplitStrings ss = new SplitStrings();
        System.out.println(ss.checkPalindromeFormation("abdef","fecab"));
    }
}
