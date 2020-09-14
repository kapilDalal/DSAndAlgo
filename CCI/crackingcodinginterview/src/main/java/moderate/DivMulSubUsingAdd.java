package moderate;

public class DivMulSubUsingAdd {

    public int divide(int a,int b){
        if(a==0)
            return 0;

        if(b==0)
            throw new RuntimeException();

        boolean neg = false;

        if(a<0 && b<0){
            neg = false;
            a = -a;
            b = -b;
        }else if(a<0 || b<0){
            neg = true;
            if(a<0)
                a = -a;
            if(b<0)
                b = -b;
        }

        int cnt = 0;
        int temp = b;
        while(a>=b){
            b += temp;
            cnt++;
        }
        return neg?-cnt:cnt;


    }

    public int mul(int a,int b){
        if(a==0 || b==0)
            return 0;

        if(a>b)
            return mul(b,a);

        boolean neg = false;
        if(a<0 && b<0) {
            neg = false;
            a = -a;
            b = -b;
        }
        else if(a<0 || b<0) {
            neg = true;

        }
        int cnt = 1;
        int temp = a;


        while(cnt<b){
            a+=temp;
            cnt++;
        }
        return a;

    }

    public int subtract(int a,int b){
        boolean neg = false;
        if(a<0 && b<0){
            a = -a;
            b = -b;
            neg = true;

        }else if(a<0 || b<0){
            if(b<0){
                b = -b;
                return a+b;
            }
            if(a<0){
                a = -a;
                neg = true;
            }
        }
        if(a<b) {
            int res =subtract(b, a) ;
            return -res;
        }


        int cnt = 0;
        while(b<a)
        {
            b+=1;
            cnt++;
        }
        return neg?-cnt:cnt;
    }














    public static void main(String[] args) {
        /*DivMulSubUsingAdd d = new DivMulSubUsingAdd();
        System.out.println(d.mul(0,-3));
        System.out.println(d.divide(-12,-7));
        System.out.println(d.subtract(0,23));*/
    }
}
