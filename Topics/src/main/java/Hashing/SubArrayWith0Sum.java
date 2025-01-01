/*
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.
 */

package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubArrayWith0Sum { // TC : O(N) and SC : O(N)

	public static int solve(ArrayList<Integer> A) {
		
		HashMap<Long, Integer> hashMap = new HashMap<>();
		hashMap.put(0L, 1);

		long runSum = 0L;

		for (int i = 0; i < A.size(); i++) {
			runSum += A.get(i);

			if (hashMap.containsKey(runSum)) {
				return 1;
			}

			hashMap.put(runSum, 1);
		}

		return 0;
	}

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, -1, 1));

		int ans = solve(A);

		System.out.println(ans);
	}

}
