package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PossibleHotelBookings {

	static class Booking implements Comparable<Booking> {
		int time;
		int aOrd;

		@Override
		public int compareTo(Booking o) {
			// TODO Auto-generated method stub
			if (this.time == o.time)
				return this.aOrd - o.aOrd;
			return this.time - o.time;
		}

		public Booking(int a, int aOrd) {
			this.time = a;
			this.aOrd = aOrd;
		}

	}

	static public boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {

		List<Booking> bookings = new ArrayList<Booking>(arrive.size());
		for (int i = 0; i < arrive.size(); i++) {
			Booking nb = new Booking(arrive.get(i), 1);
			bookings.add(nb);
		}
		for (int i = 0; i < depart.size(); i++) {
			Booking nb = new Booking(depart.get(i), 0);
			bookings.add(nb);
		}
		Collections.sort(bookings);
		int currActive = 0, maxActive = 0;
		for (int i = 0; i < bookings.size(); i++) {
			if (bookings.get(i).aOrd == 1) {
				currActive++;
				maxActive = Math.max(currActive, maxActive);
			} else
				currActive--;
		}
		System.out.println(maxActive);
		return K >= maxActive;

	}

	public static void main(String[] args) {
		List<Integer> arrive = Arrays.asList(1, 2, 3);
		List<Integer> depart = Arrays.asList(2, 3, 4);
		int K = 12;

		System.out.println(hotel(arrive, depart, K));

	}

}
