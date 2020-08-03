package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BoxStacking {
	static public class Box implements Comparable<Box> {
		int l;
		int w;
		int h;
		int a;

		public Box(int h, int w, int l) {
			this.l = l;
			this.w = w;
			this.h = h;
		}

		public void setArea(int a) {
			this.a = a;
		}

		@Override
		public int compareTo(Box o) {
			// TODO Auto-generated method stub
			return this.a - o.a;
		}
	}

	static int maxHeight(Box[] boxes) {
		int max = 0;

		Box[] allBoxes = new Box[boxes.length * 3];

		for (int i = 0; i < boxes.length; i++) {
			allBoxes[3 * i] = new Box(boxes[i].h, Math.max(boxes[i].w, boxes[i].l), Math.min(boxes[i].w, boxes[i].l));
			allBoxes[3 * i + 1] = new Box(boxes[i].w, Math.max(boxes[i].h, boxes[i].l),
					Math.min(boxes[i].h, boxes[i].l));
			allBoxes[3 * i + 2] = new Box(boxes[i].l, Math.max(boxes[i].w, boxes[i].h),
					Math.min(boxes[i].h, boxes[i].w));
		}

		for (int i = 0; i < allBoxes.length; i++) {
			allBoxes[i].setArea(allBoxes[i].l * allBoxes[i].w);

		}
		Arrays.sort(allBoxes);

		int[] mh = new int[allBoxes.length];
		
		for (int i = 0; i < mh.length; i++)
			mh[i] = allBoxes[i].h;
		
		max = mh[0];
		
		for (int i = 1; i < allBoxes.length; i++) 
		{
			int val = 0;
			for (int j = 0; j < i; j++) 
			{
				if (allBoxes[j].w < allBoxes[i].w && allBoxes[j].l < allBoxes[i].l) 
				{
					val = Math.max(val, mh[j]);
				}
			}
			mh[i] = val + allBoxes[i].h;
			max = Math.max(max, mh[i]);
		}

		return max;
	}

	public static void main(String[] args) {
		Box[] arr = new Box[4];
		arr[0] = new Box(4, 6, 7);
		arr[1] = new Box(1, 2, 3);
		arr[2] = new Box(4, 5, 6);
		arr[3] = new Box(10, 12, 32);

		System.out.println(maxHeight(arr));
	}

}
