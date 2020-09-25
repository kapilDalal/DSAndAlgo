package hard;


import java.util.TreeSet;

/*
Smallest K: Design an algorithm to find the smallest K numbers in an array.
* */
public class SmallestK {

    /*
    * if numbers are unique
    * 3,7,1,4,2
    * sort it
    * 1,2,3,4,7
    * now we can just return k-1 index for kth smallest.
    *
    * if numbers are not unique, then also we can handle by sorting
    * but still time complexity is nlogn
    * 3,7,1,1,2,2,4
    * 1,1,2,2,3,4,7
    *
    * we can achieve O(n) by adding all the elements in tree set.
    *
    *
    *
    * */

    public int smallestK(int[] arr,int k)
    {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int index = 1;
        int ele = -1;
        if(index>set.size())
            return ele;
        while(index<=k){
            ele = set.pollFirst();
            index++;
        }
        return ele;
    }

    public static void main(String[] args) {
        SmallestK sk = new SmallestK();
        System.out.println(sk.smallestK(new int[]{3,7,1,1,2,2,4},5));
    }

}
