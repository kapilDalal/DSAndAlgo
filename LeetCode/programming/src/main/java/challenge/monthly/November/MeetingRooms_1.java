package challenge.monthly.November;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRooms_1 {

    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        public Meeting(int start,int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            return this.start-o.start;
        }
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length==0)
            return true;
        List<Meeting> meetingList = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            Meeting m = new Meeting(intervals[i][0],intervals[i][1]);
            meetingList.add(m);
        }
        Collections.sort(meetingList);
        for(int i=0;i<meetingList.size()-1;i++){
            if(meetingList.get(i).end>=meetingList.get(i+1).start)
                return  false;
        }
        return true;
    }

}
