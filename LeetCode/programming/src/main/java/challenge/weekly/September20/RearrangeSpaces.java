package challenge.weekly.September20;

import java.util.ArrayList;

public class RearrangeSpaces {

    public String reorderSpaces(String text) {
        int spaces = 0;
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(ch==' ')
                spaces++;
        }
        if(spaces==0)
            return text;
        String[] s = text.split(" ");
        ArrayList<String> s1 = new ArrayList<>();
        for(int i = 0;i<s.length;i++){
            if(s[i].length()!=0)
                s1.add(s[i]);
        }
        int gap = 0;
        if(s1.size()>1)
            gap = spaces/(s1.size()-1);
        else
            gap = spaces;

        int lastGap = 0;

        if(s1.size()>1)
            lastGap = spaces%(s1.size()-1);
        else
            lastGap = gap;
        String res = "";
        for(int i=0;i<s1.size();i++){
            res += s1.get(i);
            for(int j=0;j<gap;j++){
                res += " ";
            }
        }
        res = res.trim();
        for(int j=0;j<lastGap;j++){
            res += " ";
        }
        return res;
    }

    public static void main(String[] args) {
        RearrangeSpaces rs = new RearrangeSpaces();
        System.out.println(rs.reorderSpaces("   a"));
    }
}
