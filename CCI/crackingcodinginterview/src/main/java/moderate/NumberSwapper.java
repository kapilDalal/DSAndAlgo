package moderate;

public class NumberSwapper {

    public static void main(String[] args) {
        int a = -12;
        int b = 89;

        System.out.println(a);
        System.out.println(b);


        a = a * b;
        b = a/b;
        a = a/b;

        System.out.println(a);
        System.out.println(b);


    }

}
