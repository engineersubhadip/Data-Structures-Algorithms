package Recursion;

/*
Given a number A, we need to find the sum of its digits using recursion.
A = 46; ans -> 10
 */

public class SumTheDigits {
    
	public static int recursion(int A) {
		
		if (A == 0) {
			return 0;
		}
		int rem = A % 10;
		A = A / 10;
		int result = recursion(A);
		return rem + result;
	}
	
	public static int solve(int A) {
		return recursion(A);
	}
	
	public static void main(String[] args) {
		
		int A = 192;
		
		int ans = solve(A);
		
		System.out.println(ans);

	}

}
