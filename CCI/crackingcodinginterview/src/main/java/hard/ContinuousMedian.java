package hard;

import java.util.Random;

/*
Continuous Median: Numbers are randomly generated and passed to a method. Write a program
to find and maintain the median value as new values are generated.
* */
public class ContinuousMedian {

    /*
    *
    *   (n-1)*currMedian + number
    *           /
    *           n
    * */

    int n = 0;
    int median = 0;
    public int getNumber(){

        return (int) (Math.random()*10);
    }

    public void median()
    {

        int num = getNumber();
        n++;
        System.out.print("number = "+num+"\t");
        int currMedian = ((n-1)*median + num)/n;
        System.out.println("median=" +currMedian );
        median = currMedian;
    }

    public static void main(String[] args) {
        ContinuousMedian cm = new ContinuousMedian();
        for(int i=0;i<5;i++)
            cm.median();
    }
}
