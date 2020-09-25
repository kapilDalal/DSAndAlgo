package jav.rev.threadgroup;

/*
ThreadGroup creates a group of threads.
It offers a convenient way to manage groups of threads as a unit.
This is particularly valuable in situation in which you want to
suspend and resume a number of related threads.

The thread group form a tree in which every thread group except the initial thread group has a parent.
A thread is allowed to access information about its own thread group but not to access information
about its thread group’s parent thread group or any other thread group.

more info - https://www.geeksforgeeks.org/java-lang-threadgroup-class-java/
* */
public class ThreadGroupTest {

    static class NewThread extends Thread
    {
        public NewThread(String name,ThreadGroup threadGroup){
            super(threadGroup,name);
            start();
        }
        public void run()
        {
            for(int i=0;i<1000;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("thread group test");
        NewThread first = new NewThread("first",tg);
        NewThread sec = new NewThread("sec",tg);

        System.out.println(tg.activeCount());
        System.out.println(tg.activeGroupCount());

        ThreadGroup tg_child = new ThreadGroup(tg,"child tg");
        NewThread third = new NewThread("third",tg_child);

        System.out.println(tg.activeCount());
        System.out.println(tg.activeGroupCount());
    }

}
