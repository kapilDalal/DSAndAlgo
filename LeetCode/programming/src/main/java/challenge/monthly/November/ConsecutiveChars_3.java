package challenge.monthly.November;

public class ConsecutiveChars_3 {

    public int maxPower(String s) {
        int cnt = 1;
        int max = 1;
        if(s.length()<=1)
            return s.length();

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1))
                cnt++;
            else
                cnt = 1;
            max = Math.max(cnt,max);
        }
        return max;
    }

}
