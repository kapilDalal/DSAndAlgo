package hard;

/*
Kth Multiple: Design an algorithm to find the kth number such that the only prime factors are 3, 5,
and 7. Note that 3, 5, and 7 do not have to be factors, but it should not have any other prime factors.
For example, the first several multiples would be (in order) 1, 3, 5, 7, 9, 15, 21.
* */

import java.util.HashSet;
import java.util.PriorityQueue;

public class KthMultiple {



    public void getKthMultiple(int index){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        pq.add(1);
        set.add(1);
        int num = 1;
        while(!pq.isEmpty() && i<index){
            num = pq.poll();

            if(!pq.contains(num*3) )
            {
                pq.add(num * 3);
                set.add(num * 3);
            }
            if(!pq.contains(num*5) )
            {
                pq.add(num * 5);
                set.add(num * 5);
            }

            if(!pq.contains(num*7) )
            {
                pq.add(num * 7);
                set.add(num * 7);
            }
            i++;
        }
        System.out.print(num+"\t");

    }

    public static void main(String[] args) {
        KthMultiple k =new KthMultiple();
        //for(int i=1;i<=10;i++)
            k.getKthMultiple(9);
    }

}
