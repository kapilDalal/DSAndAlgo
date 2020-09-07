package challenge.monthly.september;

import java.util.HashSet;

public class RepeatedSubstringPattern_3 {

    public static boolean repeatedSubstringPattern(String s) {
        if(s.length()<=1)
            return false;


            int mid = s.length()/2;
            String sub="";
            if(s.length()%2==0)
                sub = s.substring(0,mid);
            else
                sub = s.substring(0,mid+1);
            String temp = sub;
            while(sub.length()>=1) {
                while (s.length() >= sub.length())
                    sub = sub + temp;
                if (sub.contains(s))
                    return true;
                sub = temp.substring(0,temp.length()-1);
                temp = sub;
            }



        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("aabaabaa"));
    }
}
