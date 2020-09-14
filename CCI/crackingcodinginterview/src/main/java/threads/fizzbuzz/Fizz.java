package threads.fizzbuzz;

public class Fizz extends Thread{


    NumberIncrementer incrementer;

    public Fizz(NumberIncrementer incrementer){

        this.incrementer = incrementer;
    }

    public void run(){

        while(incrementer.num<=incrementer.end) {
            synchronized (incrementer) {
                while (incrementer.num % 3 != 0 && incrementer.num<=incrementer.end) {
                    try {
                        incrementer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(incrementer.num<=incrementer.end)
                    System.out.println("num is "+incrementer.num+" so printing fizz");
                incrementer.num++;
                incrementer.notifyAll();
            }
        }

    }

}
