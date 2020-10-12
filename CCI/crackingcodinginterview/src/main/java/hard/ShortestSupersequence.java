package hard;

/*
Shortest Supersequence: You are given two arrays, one shorter (with all distinct elements) and one
longer. Find the shortest subarray in the longer array that contains all the elements in the shorter
array. The items can appear in any order.
EXAMPLE
lnput:{1, 5, 9} | {7, 5, 9, 0, 2, 1, 3, 5, 7, 9. 1, 1, 5, 8, 8, 9, 7}
Output: [ 7, 10]
* */

import java.util.HashSet;

public class ShortestSupersequence {
    /*
    put all sub array elements in a set,
    now start from 0th index if you find an element which is in set
    store it in a subset, mark it as start.
    when the subset size becomes equal to set this will be end.
    now move the start by removing an element.
    * */
    void findSuperSequence(int[] subarray,int[] array){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i< subarray.length;i++)
            set.add(subarray[i]);
        int finalStart = 0;
        int finalEnd = Integer.MAX_VALUE;
        int currStart = 0;
        int currEnd = Integer.MAX_VALUE;

        HashSet<Integer> subset = new HashSet<>();

        for(int i=0;i< array.length;i++){
            if(set.contains(array[i]))
            {
                if(subset.size()==0)
                {
                    currStart = i;
                }

                /*if(subset.contains(array[i]))
                {

                    currStart++;
                    while(currStart< array.length && !set.contains(array[currStart]))
                        currStart++;

                }*/

                subset.add(array[i]);
            }

            if(subset.size()==set.size())
            {
                currEnd = i;

                if(finalEnd-finalStart > currEnd-currStart){
                    finalStart = currStart;
                    finalEnd = currEnd;
                }

                subset.remove(array[currStart]);
                currStart++;
                while(currStart< array.length && !set.contains(array[currStart]))
                    currStart++;
            }

        }
        System.out.println("["+finalStart+" , "+finalEnd+"]");

    }

    public static void main(String[] args) {
        /*
        lnput:{1, 5, 9} | {7, 5, 9, 0, 2, 1, 3, 5, 7, 9. 1, 1, 5, 8, 8, 9, 7}
        Output: [ 7, 10]
        * */
        ShortestSupersequence ss = new ShortestSupersequence();
        ss.findSuperSequence(new int[]{1, 5, 9},new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7});
    }

}
