package hard;

/*
Letters and Numbers: Given an array filled with letters and numbers, find the longest subarray with
an equal number of letters and numbers.
* */

import java.util.HashMap;

public class LettersAndNumbers {


    /*
    * bruteforce is to take all the sub arrays and check O(n^2)
    * ds
    * 
    * */

    public void longestSubarray(char[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int start = 0;
        int end = 0;
        for(int i=0;i<arr.length;i++){
            char ch = arr[i];
            if(Character.isAlphabetic(ch)){
                sum += 1;
            }else{
                sum -= 1;
            }
            if(map.containsKey(sum)){
                if(i-map.get(sum)+1 > end-start){
                    end = i;
                    start = map.get(sum)+1;
                }
            }else{
                map.put(sum,i);
            }
        }
        System.out.println("start = "+start+"\tend="+end);
    }

    public static void main(String[] args) {
        LettersAndNumbers ln = new LettersAndNumbers();
        ln.longestSubarray(new char[]{'a','b','c','2','3','d','e','5','f'});
    }


}
