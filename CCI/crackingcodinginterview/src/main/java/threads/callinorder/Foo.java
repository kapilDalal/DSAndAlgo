package threads.callinorder;

import java.util.concurrent.Semaphore;

public class Foo{

    Semaphore f;
    Semaphore s;

    public Foo() throws InterruptedException {
        f = new Semaphore(1);
        s = new Semaphore(1);


        f.acquire();
        s.acquire();
    }



}
