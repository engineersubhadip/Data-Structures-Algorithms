/*
Given an array A of N integers.
Find the length of the longest sub-array in the array which sums to zero.
If there is no sub-array which sums to zero then return 0.
*/

package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LongestSubarrayWith0Sum {

	public static int solve(ArrayList<Integer> A) {	 // TC : O(N) and SC : O(N)
		HashMap<Long, Integer> hashMap = new HashMap<>();
		hashMap.put(0L, -1);
		long runSum = 0L;
		int maxLen = 0;
		
		for (int i=0; i<A.size(); i++) {
			runSum += A.get(i);
			if (hashMap.containsKey(runSum)) {
				int runLen = i - hashMap.get(runSum);
				maxLen = Math.max(maxLen, runLen);
			}
			if (! hashMap.containsKey(runSum)) {
				hashMap.put(runSum, i);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, -2, 1, 2));
		
		int ans = solve(A);
		
		System.out.println(ans);
	}

}
