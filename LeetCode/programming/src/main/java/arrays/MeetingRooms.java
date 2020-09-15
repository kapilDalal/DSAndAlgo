package arrays;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
* */

import java.util.ArrayList;
import java.util.Collections;

public class MeetingRooms {

    static class Person implements Comparable<Person>{
        int time;
        boolean arrival;
        public Person(int time,boolean arrival){
            this.time = time;
            this.arrival = arrival;
        }

        @Override
        public int compareTo(Person o) {
            if(this.time==o.time){
                if(this.arrival==false)
                    return -1;
                return 1;
            }
            return this.time-o.time;
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        ArrayList<Person> bookings = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){

            Person p1 = new Person(intervals[i][0],true);
            Person p2 = new Person(intervals[i][1], false);


            bookings.add(p1);
            bookings.add(p2);

        }
        Collections.sort(bookings);
        int maxRoomsOccupied = 0;
        int currOccupied = 0;

        for(Person p : bookings){
            if(p.arrival)
                currOccupied++;
            else{
                currOccupied--;
            }
            maxRoomsOccupied = Math.max(currOccupied,maxRoomsOccupied);
        }
        return maxRoomsOccupied;
    }

    public static void main(String[] args) {
        MeetingRooms mr = new MeetingRooms();
        System.out.println(mr.minMeetingRooms(new int[][]{{0, 30},{5, 10},{15, 20}}));
    }

}
