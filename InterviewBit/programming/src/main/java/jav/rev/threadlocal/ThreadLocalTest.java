package jav.rev.threadlocal;

import java.awt.font.TextHitInfo;
import java.time.chrono.ThaiBuddhistEra;
import java.util.Random;

/*
This class provides thread local variable.
These variables differ from their normal counterparts
in that each thread that accesses one (via its get or set method) has its own,
independently initialized copy of the variable.

Basically it is an another way to achieve thread safety apart from writing immutable classes.
Since Object is no more shared there is no requirement of Synchronization which can improve
scalability and performance of application.
It extends class Object.
ThreadLocal provides thread restriction which is extension of local variable.
ThreadLocal are visible only in single thread. No two thread can see each others thread local variable.
These variable are generally private static field in classes and maintain its state inside thread.

more info - https://www.geeksforgeeks.org/java-lang-threadlocal-class-java/
* */
public class ThreadLocalTest {





    public static void main(String[] args)
    {

        ThreadLocal<String> tl = new ThreadLocal<>();


        Thread t1 = new Thread(()->{
           tl.set("1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        });
        Thread t2 = new Thread(()->{
           tl.set("2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        });
        t1.start();
        t2.start();

    }


}
