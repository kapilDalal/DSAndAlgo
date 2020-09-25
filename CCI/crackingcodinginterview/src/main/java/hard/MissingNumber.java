package hard;

/*
Missing Number: An array A contains all the integers from O to n, except for one number which
is missing. In this problem, we cannot access an entire integer in A with a single operation. The
elements of A are represented in binary, and the only operation we can use to access them is "fetch
the jth bit of A[ i ],"which takes constant time. Write code to find the missing integer. Can you do
it inO(n) time?
* */

public class MissingNumber {

    /*
    A - 0 to n
    one number missing
    * */

    static class CustomArray{
        int length;
        private int[] arr;
        public CustomArray(int[] arr){
            this.length = arr.length;
            this.arr = arr;
        }
        public int getBit(int index,int bitNumber){
            return (this.arr[index]>>bitNumber) & 1;
        }
    }
    public int getMissingNumber(CustomArray arr,int n){
        int expectedXor = 0;
        for(int i=0;i<=n;i++)
            expectedXor ^= i;

        String actualXor = "";

        for(int i=0;i<32;i++){
            int xor = 0;
            for(int j=0;j<arr.length;j++){
                xor = xor ^ arr.getBit(j,i);
            }
            actualXor = xor + actualXor;
        }
        int aXor = Integer.parseInt(actualXor,2);
        return expectedXor ^ aXor;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        CustomArray arr = new CustomArray(new int[]{0,1,2,3,4});
        int missingNumber = mn.getMissingNumber(arr, 5);
        System.out.println(missingNumber);
    }


}
