package math;

import java.util.ArrayList;

public class FizzBuzz {
	static public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> res = new ArrayList<String>();
        for(int i=1;i<=A;i++){
            String str = "";
            if(i%3==0 && i%5==0){
                str = "FizzBuzz";
            }
            else if(i%3==0){
                str = "Fizz";
            }
            else if(i%5==0){
                str = "Buzz";
            }
            else{
                str = String.valueOf(i);
            }
            res.add(str);
        }
        return res;
    }
	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));
	}

}
