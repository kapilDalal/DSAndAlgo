package challenge.monthly.september;

import java.util.ArrayList;
import java.util.Collections;

public class CarPooling_21 {

    static class Trip implements Comparable<Trip>{
        int location;
        boolean arrival;
        int capacity;

        public Trip(int capacity,int location,boolean arrival){
            this.location = location;
            this.capacity = capacity;
            this.arrival = arrival;
        }

        @Override
        public int compareTo(Trip o) {
            if(this.location ==o.location){
                if(this.arrival==false)
                    return -1;
                return 1;
            }
            return this.location -o.location;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        ArrayList<Trip> tripsList = new ArrayList<>();
        int totalCapacity = 0;
        for(int i=0;i< trips.length;i++){
            int c = trips[i][0];
            int s = trips[i][1];
            Trip t1 = new Trip(c,s,true);
            tripsList.add(t1);
            int d = trips[i][2];
            Trip t2 = new Trip(c,d,false);
            tripsList.add(t2);
        }
        Collections.sort(tripsList);
        for(Trip t : tripsList){
            if(t.arrival)
                totalCapacity+=t.capacity;
            else
                totalCapacity-=t.capacity;
            if(totalCapacity>capacity)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CarPooling_21 cp = new CarPooling_21();
        int[][] trips = {{3,2,7},{3,7,9},{8,3,9}};
        int capacity = 10;
        System.out.println(cp.carPooling(trips,capacity));
    }
}
