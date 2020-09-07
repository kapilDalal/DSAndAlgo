package challenge.monthly.september;

import java.util.Arrays;
import java.util.Comparator;

public class CountPrimeString {


    static boolean prime[];
    static int count = 0;

    public static  int countPrimeStrings(String s){
        count=0;
        generatePrimes(1000000);
        prime[0] = false;
        prime[1] = false;
        countPrimeUtil(s,"");
        return count;
    }
    static void generatePrimes(int n)
    {
        prime = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }

    private static void countPrimeUtil(String rem,String prefix){
        if(rem.length()==0){
            count++;
            count = count%1000000007;
        }
        for(int i=0;i<=rem.length();i++){
            String sub = rem.substring(0,i);
            if(sub.length()>0 && Integer.parseInt(sub)==0)
                break;
            if(sub.length()>0 && Integer.parseInt(sub)>1000000)
                break;
            if(sub.length()>0 && prime[Integer.parseInt(sub)]){
                prefix = prefix+sub;
                countPrimeUtil(rem.substring(i),prefix);
            }
        }

    }




    public static void main(String[] args) {

    }




}
