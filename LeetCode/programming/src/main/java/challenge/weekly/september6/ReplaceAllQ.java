package challenge.weekly.september6;

public class ReplaceAllQ {
    String alpha = "abcdefghijklmnopqrstuvwxyz";
    public String modifyString(String s) {
        String res = "";
        if(s.length()<1)
            return s;
        if(s.charAt(0)=='?'){
            char ch = getChar(s,res,0);
            res = res + ch;
        }else{
            res = res + s.charAt(0);
        }
        for(int i=1;i<s.length();i++){
            char ch= s.charAt(i);
            if(ch=='?'){
                char c = getChar(s,res,i);
                res = res + c;
            }else{
                res = res + ch;
            }
        }

        return res;
    }

    private char getChar(String s,String res, int i) {
        if(i==0){
            if(i+1<s.length()){
                for(int j=0;j<alpha.length();j++){
                    if(alpha.charAt(j)!=s.charAt(i+1))
                        return alpha.charAt(j);
                }
            }else{
                return alpha.charAt(0);
            }
        }
        if(i==s.length()-1){
            for(int j=0;j<alpha.length();j++){
                if(alpha.charAt(j)!=res.charAt(i-1))
                    return alpha.charAt(j);
            }
        }

        for(int j=0;j<alpha.length();j++){
            if(alpha.charAt(j)!=s.charAt(i+1) && alpha.charAt(j)!=res.charAt(i-1))
                return alpha.charAt(j);
        }
        return 'a';
    }

    public static void main(String[] args) {
        ReplaceAllQ rq = new ReplaceAllQ();
        System.out.println(rq.modifyString("?????????????????????????????????"));
    }


}
