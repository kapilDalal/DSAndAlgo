package searchingandsorting;

import java.util.HashMap;

public class NoSizeSortedSearch {

    private static class Listy{
        HashMap<Integer,Integer> map = new HashMap<>();
        public void put(int key,int value){
            map.put(key,value);
        }
        public int get(int key){
            if(map.containsKey(key))
                return map.get(key);
            return -1;
        }
    }


    /*
    * idea is to find size using binary search
    * and then get the index using binary search
    * */

    public int getIndex(Listy l,int target){
        int size = getSize(l,0,Integer.MAX_VALUE);
        int start = 0;
        int end = size;
        while(start<=end){
            int mid = (start+end)/2;
            if(l.get(mid)==target)
                return mid;
            else if(l.get(mid)<target)
                start = mid+1;
            else
                end = mid-1;

        }
        return -1;
    }

    private int getSize(Listy l, int low, int high) {

        while (low<high){
            int mid = (low+high)/2;
            if(l.get(mid)==-1){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Listy l = new Listy();
        l.put(0,5);
        l.put(1,8);
        l.put(2,17);
        l.put(3,130);
        l.put(4,290);
        l.put(5,300);
        l.put(6,397);
        NoSizeSortedSearch ns = new NoSizeSortedSearch();
        System.out.println(ns.getIndex(l,400));
    }


}
