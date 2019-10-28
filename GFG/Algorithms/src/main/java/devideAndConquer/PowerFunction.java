package devideAndConquer;

public class PowerFunction {
	// O(n)
	static int pow(int x, int n) {
		if (n == 0)
			return 1;

		if (n >= 2) {

			int lp = n / 2;
			int rp = n - n / 2;
			int l = pow(x, lp);
			int r = pow(x, rp);

			return l * r;
		}

		return x;
	}

	// O(log(n))
	static int powOptimised(int x, int n) {
		if (n == 0)
			return 1;
		int temp = powOptimised(x, n / 2);
		if (n % 2 == 0)
			return temp * temp;
		else
			return x * temp * temp;
	}

	// for negative power and float base
	static float powNeg(float x, int y) {

		if (y == 0)
			return 1;
		float temp = powNeg(x, y / 2);
		

		if (y % 2 == 0)
			return temp * temp;
		else {
			if (y > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}

	}

	public static void main(String[] args) {
		System.out.println(powOptimised(7, 4));
	}

}
