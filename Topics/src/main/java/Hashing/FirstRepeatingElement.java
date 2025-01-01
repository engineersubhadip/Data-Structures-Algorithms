/*
Given an integer array A of size N, find the first repeating element in it.

We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.

If there is no repeating element, return -1.
*/

package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FirstRepeatingElement {

	public static int solve(ArrayList<Integer> A) { // TC : O(N) and SC : O(N)

		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < A.size(); i++) {
			if (hashMap.containsKey(A.get(i))) {
				int prevVal = hashMap.get(A.get(i));
				hashMap.put(A.get(i), prevVal + 1);
			} else {
				hashMap.put(A.get(i), 1);
			}
		}

		for (int i = 0; i < A.size(); i++) {
			if (hashMap.get(A.get(i)) > 1) {
				return A.get(i);
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(6, 10, 5, 4, 9, 120));
		int ans = solve(A);

		System.out.println(ans);
	}

}
