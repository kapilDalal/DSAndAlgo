package stacksandqueues;

public class ThreeStacks {
	int[] arr;
	int top1, top2, top3;
	int s1, s2, s3;
	int e1, e2, e3;
	int n;

	public ThreeStacks(int size) {
		n = size;
		arr = new int[n];
		init();
	}

	private void init() {
		int offset = n / 3;
		top1 = -1;
		top2 = top1 + offset - 1;
		top3 = top2 + offset - 1;
		s1 = top1+1;
		s2 = top2+1;
		s3 = top3+1;
		e1 = top2;
		e2 = top3;
		e3 = n;
	}

	public void push(int stackNumber, int val) {
		if (stackNumber == 1) {
			if (top1 < e1) {
				arr[++top1] = val;
			}
		} else if (stackNumber == 2) {
			if (top2 < e2) {
				arr[++top2] = val;
				// top2++;
			}
		} else if (stackNumber == 3) {
			if (top3 < e3) {
				arr[++top3] = val;
				//	top3++;
			}
		}
	}

	public int pop(int stackNumber) {
		int val = -1;
		if (stackNumber == 1) {
			if (top1 >= s1) {
				val = arr[top1];
				top1--;
			}
		} else if (stackNumber == 2) {
			if (top2 >= s2) {
				val = arr[top2];
				top2--;
			}
		} else if (stackNumber == 3) {
			if (top3 >= s3) {
				val = arr[top3];
				top3--;
			}
		}
		return val;
	}

	public static void main(String[] args) {
		ThreeStacks ts = new ThreeStacks(6);
		ts.push(1, 1);
		ts.push(2, 2);
		ts.push(3, 3);
		System.out.println(ts.pop(3));
		System.out.println(ts.pop(1));
	}

}
