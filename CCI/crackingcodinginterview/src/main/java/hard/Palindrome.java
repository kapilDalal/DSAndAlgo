package hard;

/*

Given a String S1 and String S2.
Convert string S1 to a palindrome string such S2 is a substring of that palindromic string.
Only operation allowed on S1 is replacement of any character with any other character.
Find minimum number of operations required.

s1 = archit
s2 = ar

output - 3
arccra



* */

public class Palindrome {


    static int Palin_sol(String S1, String S2){
        // Write your code here
        int l1=S1.length(),l2=S2.length();
        int min=Integer.MAX_VALUE;
        if(l2>l1){
            return -1;
        }
        for(int i=0 ; i<l1-l2+1 ; i++){

            String temp=S1.substring(0,i)+S2+S1.substring(i+l2);
            int currCost=0;
            for(int j=i ; j<i+l2 ; j++){

                if(S1.charAt(j)!=temp.charAt(j))
                    currCost++;
            }
            int flag=0;
            for(int j=0 ; j<Math.ceil(l1/2.0) ; j++){

                if((j<i || j>=i+l2) && temp.charAt(j)!=temp.charAt(l1-j-1))
                    currCost++;
                else if(temp.charAt(j)!=temp.charAt(l1-j-1) && (l1-j-1<i || l1-j-1>=i+l2))
                    currCost++;
                else if(temp.charAt(j)!=temp.charAt(l1-j-1))
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                min=Math.min(min,currCost);
        }
        if(min==Integer.MAX_VALUE)
            return -1;

        return min;

    }

    public static void main(String[] args) {
        System.out.println(Palin_sol("abcd","nmm"));
    }

    /*


    * */
}
