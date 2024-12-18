package Recursion;

/*
Print in a decreasing sequence 5,4,3,2,1,...
 */

public class PrintDecreasingManner {
	
	static String printDecreasing(int N) {
		if (N == 1) {
			String ans = "1";
			return ans;
		}
		
		String returnVal = printDecreasing(N-1);
		String result = N + " "+returnVal;
		
		return result;
	}
	
	public static void main(String[] args) {
		
		String ans = printDecreasing(12);
		System.out.println(ans);

	}

}
