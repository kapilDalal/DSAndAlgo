package hard;

/*
Random Set: Write a method to randomly generate a set of m integers from an array of size n. Each
element must have equal probability of being chosen.
* */

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

public class RandomSet {

    /* check with random.getBoolean()
       take a set and loop through the
       array and store indices in the set
       using random.getboolean() to chech if
       we should store the index in set, if not already present.
    */
    public void randomSet(int[] arr,int m){
        HashSet<Integer> set = new LinkedHashSet<>();
        Random random = new Random();
        while(set.size()<m){

            int index = (int) (Math.random()*arr.length);
            if(!set.contains(index)){
                if(random.nextBoolean()){
                    set.add(index);
                }
            }
        }
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext())
            System.out.print(iterator.next()+"\t");
    }

    public static void main(String[] args) {
        RandomSet s = new RandomSet();
        for(int i=0;i<10;i++){
            s.randomSet(new int[]{0,1,2,3,4},5);
            System.out.println();
        }
    }
}
