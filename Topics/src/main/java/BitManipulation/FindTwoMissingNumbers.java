/*
Given an array A of length N where all the elements are distinct and are in the range [1, N+2].

Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.

A = [3, 2, 4] ; ans -> [1, 5]
A = [5, 1, 3, 6] ; ans -> [2, 4]
 */

package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTwoMissingNumbers {
	
	static boolean checkBit(int N, int bit) {
		if ((N & (1 << bit)) == 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 1, 3, 6));
		
		int n = A.size();
		
		int ans1 = 0;
		
		for (int i=1; i<=(n+2); i++) {
			ans1 ^= i;
		}
		
		int ans2 = 0;
		
		for (int i=0; i<A.size(); i++) {
			ans2 ^= A.get(i);
		}
		
		int res = ans1 ^ ans2;
		
		int bifIdx = -1;
		
		for (int i=0; i<=31; i++) {
			boolean status = checkBit(res, i);
			if (status) {
				bifIdx = i;
				break;
			}
		}
		
		int res1 = 0; // set
		int res2 = 0; // unset
		
		for (int i=1; i<=(n+2); i++) {
			boolean status = checkBit(i, bifIdx);
			if (status) {
				res1 ^= i;
			}else {
				res2 ^= i;
			}
		}
		
		for (int i=0; i<A.size(); i++) {
			boolean status = checkBit(A.get(i), bifIdx);
			if (status) {
				res1 ^= A.get(i);
			}else {
				res2 ^= A.get(i);
			}
		}
		
		if (res1 < res2) {
			ArrayList<Integer> finalOutput = new ArrayList<>(Arrays.asList(res1, res2));
			System.out.println(finalOutput);
		}else {
			ArrayList<Integer> finalOutput = new ArrayList<>(Arrays.asList(res2, res1));
			System.out.println(finalOutput);
		}
	}

}
