package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.

Since the answer can be large, return the remainder after the dividing the answer by 109+7.
A = [3, 4, 2]
ans :- 14

Contribution of Each bit :- (number of set bit counts) * [2 ^(i)]
 */


public class SumXOROfAllPairs {
	
	static boolean checkBit(int N, int bit) {
		if ((N & (1 << bit)) == 0) {
			return false;
		}
		return true;
	}
	
	
    static int pairCount(long oneCount, long zeroCount, int currBit) {

		long total = 0;
		long mod = 1000000007L;
		
		long runCount = ((zeroCount * oneCount) % mod) * ((1 << currBit) % mod);
		total = (total + runCount) % mod;

		int finalCount = (int)total;
		
		return finalCount;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
		
        long finalCount = 0;
		long mod = 1000000007L;
		
		for (int i=0; i<=31; i++) {
			int currBit = i;
            long oneCount = 0;
            long zeroCount = 0;
			for (int j=0; j<A.size(); j++) {
				int currNum = A.get(j);
				boolean status = checkBit(currNum, currBit);
				if (status) {
					oneCount ++;
				}else {
					zeroCount ++;
				}
			}
			int runCount = pairCount(oneCount, zeroCount, currBit);
			finalCount = (finalCount + runCount) % mod;
		}
		
        System.out.println((int)finalCount);
	}

}
