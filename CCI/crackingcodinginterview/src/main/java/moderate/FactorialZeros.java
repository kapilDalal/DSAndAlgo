package moderate;

public class FactorialZeros {

    public int countTrailingZeros(int n){
        int count=0;
        int div = 5;
        if(n<5)
            return count;
        while(n/div>0){
            count += n /div;
            div = div * 5;
        }
        return count;
    }

    public static void main(String[] args) {
        FactorialZeros z = new FactorialZeros();
        System.out.println(z.countTrailingZeros(125));
    }

}
