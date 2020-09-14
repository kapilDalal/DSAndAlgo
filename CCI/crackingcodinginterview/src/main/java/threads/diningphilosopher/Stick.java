package threads.diningphilosopher;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Stick {

    private Lock lock;
    int number;


    public Stick(int num){
        this.number = num;
        this.lock = new ReentrantLock();
    }
    public int getStick(){
        if(lock.tryLock())
            return this.number;
        return -1;
    }
    public void release(){
        lock.unlock();
    }



}
