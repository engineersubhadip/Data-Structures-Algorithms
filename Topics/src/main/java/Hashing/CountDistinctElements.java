/*
Given an array A of N integers, return the number of unique elements in the array.
 */

package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.*;

public class CountDistinctElements {
	
	public static int solve(ArrayList<Integer> A) { // TC : O(N) and SC : O(N)
		
		Set<Integer> hashSet = A.stream().collect(Collectors.toSet());
		return hashSet.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 4, 3, 6, 6));
		
		System.out.println(solve(A));
	}

}
