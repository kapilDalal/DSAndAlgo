package hard;

/*
Shuffle: Write a method to shuffle a deck of cards. It must be a perfect shuffle
- in other words, each of the 52! permutations of the deck has to be equally likely.
Assume that you are given a random number generator which is perfect.
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Shuffle {

    /*
    * I will take a set
    * and while set size is not equals to 52
    * i will use Math.rand()*52 to get the card, if it not present insert
    * else try in next cycle.
    * */
    public void shuffle()
    {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while(set.size()!=52)
        {
            int num = (int) (Math.random()*52 + 1);
            if(!set.contains(num))
                set.add(num);
        }
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext())
            System.out.print(iterator.next()+"\n");
    }



    public static void main(String[] args) {
        Shuffle s = new Shuffle();
        s.shuffle();
    }

}
