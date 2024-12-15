package BitManipulation;

/*
 * If a number is a power of 2, then total set bit count will be 1.
 * Negative Numbers is always False
 */

public class Leetcode231_PowerOfTwo {
	
	static boolean checkBit(int N, int bit) {
		if ((N & (1 << bit)) == 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		int N = 3;
		
		if (N < 0) {
			System.out.println(false);
		}
		
		int count = 0;
		
		for (int i=0; i<=31; i++) {
			boolean status = checkBit(N,i);
			if (status) {
				count ++;
			}
		}
		
		System.out.println(count == 1);
	}

}
