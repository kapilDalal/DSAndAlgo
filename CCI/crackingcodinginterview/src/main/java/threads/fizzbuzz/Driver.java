package threads.fizzbuzz;

public class Driver {

    public static void main(String[] args) {
        NumberIncrementer incrementer = new NumberIncrementer(20);
        Fizz fizz = new Fizz(incrementer);
        Buzz buzz = new Buzz(incrementer);
        FizzBuzz fizzBuzz = new FizzBuzz(incrementer);

        incrementer.start();
        fizz.start();
        buzz.start();
        fizzBuzz.start();

    }

}
