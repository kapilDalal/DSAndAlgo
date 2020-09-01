package recursionanddynamicprogramming;

public class RecursiveMultiply {

    public static int mul(int a,int b){
        if(b==1)
            return a;
        if(b%2==0) {
            int res = mul(a,b/2);
            return res + res;
        }
        else{
            int res = mul(a,b/2);
            return res + res + a;
        }

    }

    public static void main(String[] args) {
        System.out.println(mul(12,8));
    }
}
