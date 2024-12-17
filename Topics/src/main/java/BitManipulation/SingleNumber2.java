/*
Given an array of integers, every element appears thrice except for one, which occurs once.

Find that element that does not appear thrice.

NOTE: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
ans : 4
*/

package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber2 {
	
	static boolean checkBit(int N, int bit) {
		if ((N & (1 << bit)) == 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		final List<Integer> A = new ArrayList<>(Arrays.asList(0, 0, 0, 1));
		
		int ans = 0;
		
		for (int i=0; i<=31; i++) {
			int currBit = i;
			int runCount = 0;
			for (int j=0; j<A.size(); j++) {
				boolean status = checkBit(A.get(j), currBit);
				if (status) {
					runCount ++;
				}
			}
			if (runCount % 3 == 1) {
				ans = ans | (1 << currBit);
			}
		}
		
		System.out.println(ans);

	}

}
