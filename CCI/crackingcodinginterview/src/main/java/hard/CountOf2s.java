package hard;


/*
Count of 2s: Write a method to count the number of 2s that appear in all the numbers between O
and n (inclusive).
EXAMPLE
Input: 25
Output: 9 (2, 12, 20, 21, 22, 23, 24 and 25. Note that 22 counts for two 2s.)
* */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountOf2s {

    /*
    * Bruteforce is simple, parse all number from 0 to n in strings[]
    * now traverse the array and check number of 2's in each string.
    *
    * now, optimised way is to take a queue and put 2 in this
    * then take out elements from queue and for
    * each element append 0 to 9 at front and back, check if the
    * resultant number is less than target if yes put in queue.
    */
    public int countBrute(int n){

        String[] arr = new String[n+1];
        for(int i=0;i<=n;i++){
            arr[i] = String.valueOf(i);
        }
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            String str = arr[i];
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='2')
                    cnt++;
            }
        }
        return cnt;
    }

    public void countOptimized(int n){
        Queue<String> q = new LinkedList<>();
        q.add("0");
    }

    public static void main(String[] args) {
        CountOf2s c2 = new CountOf2s();
        System.out.println(c2.countBrute(25));
        Scanner in = new Scanner(System.in);
        in.nextInt();
        in.nextLine();
    }



}
