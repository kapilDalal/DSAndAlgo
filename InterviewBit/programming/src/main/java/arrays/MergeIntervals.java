package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

	static public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		public String toString() {
			return "["+this.start + " " + this.end+"]";
		}
	}

	class SortIntervalByStart implements Comparator<Interval> {

		@Override
		public int compare(Interval first, Interval second) {
			// TODO Auto-generated method stub
			return first.start - second.start;
		}

	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		intervals.add(newInterval);

		Collections.sort(intervals, new SortIntervalByStart());
		//System.out.println(intervals);
		for(int i=0;i<intervals.size()-1;i++){
			Interval f = intervals.get(i);
			Interval s = intervals.get(i+1);
			if(f.end>=s.start){
				if(s.end>f.end)
					f.end = s.end;
				intervals.remove(i+1);
				i--;
			}
		}
		//System.out.println(intervals);
		return intervals;
	}

	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		ArrayList<Interval> intervals = new ArrayList<>();
		Interval fir = new Interval(1, 3);
		Interval sec = new Interval(6, 9);
		/*Interval thi = new Interval(6, 7);
		Interval fou = new Interval(8, 10);
		Interval fif = new Interval(12, 16);*/
		Interval six = new Interval(2, 5);
		intervals.add(fir);
		intervals.add(sec);
		/*intervals.add(thi);
		intervals.add(fou);
		intervals.add(fif);*/
		mi.insert(intervals, six);

	}

}
