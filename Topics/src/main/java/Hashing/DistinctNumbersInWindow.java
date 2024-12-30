/*
You are given an array of N integers, A1, A2 ,..., AN and an integer B. 
Return the of count of distinct numbers in all windows of size B.
Formally, return an array of size N-B+1 where i'th element in this array contains 
number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
NOTE: if B > N, return an empty array.
 */

package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumbersInWindow {

	public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) { // TC : O(N-K+1) and SC : O(N)
		
		if (B > A.size()) {
			ArrayList<Integer> result = new ArrayList<>(Arrays.asList());
			return result;
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		
		int start = 0;
		int end = B-1;
		
		for (int i=start; i<=end; i++) {
			if (hashMap.containsKey(A.get(i))) {
				int prevVal = hashMap.get(A.get(i));
				hashMap.put(A.get(i), prevVal+1);
			} else {
				hashMap.put(A.get(i), 1);
			}
		}
		
		result.add(hashMap.keySet().size());
		
		start += 1;
		end += 1;
		
		while (end <= A.size()-1) {
			hashMap.put(A.get(start-1), hashMap.get(A.get(start-1))-1);
			if (hashMap.get(A.get(start-1)) == 0) {
				hashMap.remove(A.get(start-1));
			}
			
			if (hashMap.containsKey(A.get(end))) {
				int prevVal = hashMap.get(A.get(end));
				hashMap.put(A.get(end), prevVal+1);
			} else {
				hashMap.put(A.get(end), 1);
			}
			
			result.add(hashMap.keySet().size());
			
			start ++;
			end ++;
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList(Arrays.asList(1, 1, 2, 2));
		int B = 18;
		
		System.out.println(dNums(A,B));

	}

}
