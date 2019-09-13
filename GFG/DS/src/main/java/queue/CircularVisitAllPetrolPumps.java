package queue;

public class CircularVisitAllPetrolPumps {

	public static int startingPointToCompleteTheCircle(Integer[] petrol, Integer[] distance) {
		

		int start = 0;
		int end = start + 1;
		int currPetrol = petrol[start] - distance[start];
		while (start != end || currPetrol<0) { //currPetrol<0 for a case like Integer[] petrol = {4,4,6,7}; Integer[] distance = {6,5,9,3};

			while (currPetrol < 0 && start != end) {
				currPetrol -= petrol[start] - distance[start];

				start = (start + 1) % petrol.length;

				if (start == 0)
					return -1;
			}
			currPetrol += petrol[end] - distance[end];
			end = (end + 1) % petrol.length;
		}

		return start;
	}
	
	public static void main(String[] args) {
		Integer[] petrol = {4,4,6,7};
		Integer[] distance = {6,5,9,3};
		System.out.println(startingPointToCompleteTheCircle(petrol, distance));
	}

}
