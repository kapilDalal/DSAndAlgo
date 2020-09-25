package hard;
/*
Add Without Plus: Write a function that adds two numbers. You should not use + or any arithmetic
operators.
* */
public class AddWithoutPlus {

    /*
    the question states that i can not use any arithmetic operator to add, so i think i will need
    some bit operation for addition now need to figure out, how
    let's take an example 2 + 3 = 5
    2 - 0010
    3 - 0011
    5 - 0101

    another example 2+4 = 6
    2 - 0010
    4 - 0100
    6 - 0110

    another example - 19 + 17
    19 - 10011
    17 - 10001
    36 -100100

    great we can use | operator
    * */

    public int addWithoutArithmetic(int a,int b){
        String s1 = Integer.toBinaryString(a);
        String s2 = Integer.toBinaryString(b);

        String res = "";
        int i = s1.length()-1;
        int j = s2.length()-1;
        int c = 0;
        while(i>=0 && j>=0)
        {
            int f = s1.charAt(i)-'0';
            int s = s2.charAt(j)-'0';
            int r = 0;
            if((f==1 && s==1) && c==1)
            {
                r = 1;
                c = 1;
            }
            else if((f==1 && s==1) && c==0)
            {
                c = 1;
            }
            else if((f==1 || s==1) && c==1)
            {
                c = 1;
            }
            else if((f==1 || s==1) && c==0)
            {
                r = 1;
                c = 0;
            }
            else if((f==0 && s==0) && c==1)
            {
                r = 1;
                c = 0;
            }
            else if((f==0 && s==0) && c==0)
            {
                c=0;
            }
            res = r + res;
            i--;
            j--;
        }

        while(i>=0)
        {
            int r = 0;
            int f = s1.charAt(i)-'0';
            if(f==1 && c==1)
            {
                r = 1;
                c = 1;
            }
            else if(f==1 || c==1){
                r = 1;
                c = 0;
            }
            res = r + res;
            i--;
        }
        while(j>=0){
            int r = 0;
            int s = s1.charAt(j)-'0';
            if(s==1 && c==1)
            {
                r = 1;
                c = 1;
            }
            else if(s==1 || c==1){
                r = 1;
                c = 0;
            }
            res = r + res;
            j--;
        }
        if(c==1)
            res = c + res;

        return Integer.parseInt(res,2) ;
    }

    int add(int a, int b)
    {
        if(b==0)
            return a;
        int sum = a ^ b;
        int carry= (a & b) << 1;
        return add(sum,carry);
    }

    public static void main(String[] args) {
        AddWithoutPlus ap = new AddWithoutPlus();
        System.out.println(ap.add(19,17));
    }

}
