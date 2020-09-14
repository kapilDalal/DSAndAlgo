package threads.diningphilosopher;

import java.util.Arrays;
import java.util.List;

public class Driver {

    List<Stick> sticks;
    List<Philosopher> philosophers;

    public Driver(int count){
        this.sticks = Arrays.asList(new Stick[count]);
        this.philosophers = Arrays.asList(new Philosopher[count]);
        for(int i=0;i<count;i++)
            sticks.set(i,new Stick(i));

        for(int i=0;i<count;i++)
            philosophers.set(i,new Philosopher(i,sticks));
    }

    public void startEating(){
        for(int i=0;i<philosophers.size();i++)
            philosophers.get(i).start();

    }

    public static void main(String[] args) {
        Driver d = new Driver(4);
        d.startEating();
    }

}
