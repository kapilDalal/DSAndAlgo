package hard;

/*
Missing Two: You are given an array with all the numbers from 1 to N appearing exactly once,
except for one number that is missing. How can you find the missing number in O(N) time and
0(1) space? What if there were two numbers missing?
* */
public class MissingTwo {

    /*
    * if one number is missing we can simply find that by XOR (1 to n) xor (1 to n-1)
    *
    * if two numbers are missing then
    * a+b+c+d...+n - a+b+c+d...n(missing numbers)=m1+m2
    *
    * a^2+b^2+c^2+d^2...+n^2 - a^2+b^2+c^2+d^2...+n^2(missing numbers) = m1^2 + m2^2
    *
    * */

}
