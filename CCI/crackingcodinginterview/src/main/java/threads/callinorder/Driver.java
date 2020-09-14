package threads.callinorder;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        First first = new First(foo);
        Second sec = new Second(foo);
        Third third = new Third(foo);
        first.start();
        sec.start();
        third.start();
    }
}
