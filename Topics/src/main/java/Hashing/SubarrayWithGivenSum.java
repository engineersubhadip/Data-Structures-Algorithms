/*
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.
*/

package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubarrayWithGivenSum {

	public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) { // TC : O(N) and SC : O(N)
		ArrayList<Integer> ans = new ArrayList<>();

		HashMap<Long, Integer> hashMap = new HashMap<>();
		hashMap.put(0L, -1);
		long runSum = 0L;
		int startPoint = -1;
		int endPoint = -1;

		for (int i = 0; i < A.size(); i++) {
			runSum += A.get(i);
			if (hashMap.containsKey(runSum - B)) {
				startPoint = hashMap.get(runSum - B) + 1;
				endPoint = i;
				break;
			}
			if (hashMap.containsKey(runSum) == false) {
				hashMap.put(runSum, i);
			}
		}

		if (startPoint == -1) {
			ans.add(-1);
			return ans;
		}

		for (int i = startPoint; i <= endPoint; i++) {
			ans.add(A.get(i));
		}

		return ans;
	}

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 10, 20, 100, 105));
		int B = 110;
		
		ArrayList<Integer> ans = solve(A, B);
		
		System.out.println(ans);
	}

}
