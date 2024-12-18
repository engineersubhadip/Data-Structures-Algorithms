package Recursion;

/*
 * Print in an increasing manner 1,2,3,4...
 */

public class PrintIncreasingManner {
	
	static String printIncreasing(int N) {
		if (N == 1) {
			String ans = "";
			ans += "1";
			return ans;
		}
		String result = printIncreasing(N-1);
		String ans =  result+" "+ N;
		return ans;
	}
	
	public static void main(String[] args) {
		String ans = printIncreasing(12);
		System.out.println(ans);
	}

}
