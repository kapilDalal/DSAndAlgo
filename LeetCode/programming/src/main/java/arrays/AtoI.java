package arrays;

public class AtoI {
    public static int myAtoi(String str) {
        long res = 0;
        int i=0;
        boolean neg = false;
        if(str.length()==0)
            return (int)res;
        while(i<str.length() && str.charAt(i)==' ')
            i++;
        if(i<str.length() && (str.charAt(i)=='-' || str.charAt(i)=='+')){
            if(str.charAt(i)=='-')
                neg=true;
            i++;
        }
        for(;i<str.length();i++){
            Character ch = str.charAt(i);
            if(ch>='0' && ch<='9'){
                int num = ch - '0';
                res = res*10 + num;
            }else{
                break;
            }

            if(neg && -1*res<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if(!neg && res>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        if(neg)
            res = -1*res;

        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("     91283472332"));
    }
}
