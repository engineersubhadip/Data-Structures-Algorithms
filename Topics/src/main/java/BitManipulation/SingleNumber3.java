/*
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.
Note: Return the two numbers in ascending order.

A = [1, 2, 3, 1, 2, 4]

ans : [3,4]
 */

package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleNumber3 {
	
	static boolean checkBit(int N, int bit) {
		if ((N & (1 << bit)) == 0) {
			return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2));
		
		int ans = 0;
		
		for (int i=0; i<A.size(); i++) {
			ans ^= A.get(i);
		}
		
		int bifIdx = -1;
		
		for (int i=0; i<=31; i++) {
			int currBit = i;
			boolean status = checkBit(ans, currBit);
			if (status) {
				bifIdx = i;
				break;
			}
		}
		
		int ans1 = 0; // set
		int ans2 = 0; // unset
		
		for (int i=0; i<A.size(); i++) {
			boolean status = checkBit(A.get(i), bifIdx);
			if (status) {
				ans1 ^= A.get(i);
			}else {
				ans2 ^= A.get(i);
			}
		}
		
		if (ans1 < ans2) {
			ArrayList<Integer> result = new ArrayList<>(Arrays.asList(ans1, ans2));
			System.out.println(result);
		}else {
			ArrayList<Integer> result = new ArrayList<>(Arrays.asList(ans2, ans1));
			System.out.println(result);
		}
	}

}
