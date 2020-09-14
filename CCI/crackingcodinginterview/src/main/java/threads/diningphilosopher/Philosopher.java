package threads.diningphilosopher;

import java.util.List;

public class Philosopher extends Thread{

    int pid;
    List<Stick> sticks;

    public Philosopher(int id, List<Stick> sticks){
        this.pid = id;
        this.sticks = sticks;
    }

    public int getPhilosopher(){
        return this.pid;
    }

    @Override
    public void run() {
        Stick s1 = sticks.get(pid);
        Stick s2 = sticks.get((pid+1)%sticks.size());

        if(s1.number>s2.number){
            Stick temp = s1;
            s1 = s2;
            s2 = temp;
        }

        while(!pickUp(s1,s2)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("philosopher "+pid+" has got stick "+s1.number);
        System.out.println("philosopher "+pid+" has got stick "+s2.number);
        System.out.println("philosopher "+pid+" eating...");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("philosopher "+pid+" finished eating...");



        s1.release();
        s2.release();


    }

    private boolean pickUp(Stick s1,Stick s2) {
        if(s1.getStick()==-1)
            return false;
        if(s2.getStick()==-1){
            s1.release();
            return false;
        }
        return true;
    }
}
