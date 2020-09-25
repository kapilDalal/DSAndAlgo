package hard;

/*
Majority Element: A majority element is an element that makes up more than half of the items in
an array. Given a positive integers array, find the majority element. If there is no majority element,
return -1. Do this in O(N) time and 0(1) space.
EXAMPLE
Input: 1 2 5 9 5 9 5 5 5
Output: 5
*/

public class MajorityElement {

    public int getMajorityElement(int[] arr){
        if(arr.length==0)
            return -1;

        int majCount = 1;
        int majElement = arr[0];

        for(int i=1;i<arr.length;i++){

            if(arr[i]==majElement)
                majCount++;
            else{
                if(majCount==0){
                    majElement = arr[i];
                    majCount = 1;
                }
                else{
                    majCount--;
                }
            }

        }
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==majElement)
                cnt++;
        }
        return cnt>arr.length/2?majElement:-1;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        System.out.println(me.getMajorityElement(new int[]{5, 2, 5, 9, 5}));
    }

}
