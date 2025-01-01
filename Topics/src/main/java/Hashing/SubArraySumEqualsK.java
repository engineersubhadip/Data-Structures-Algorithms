/*
Given an array of integers A and an integer B.
Find the total number of sub-arrays having sum equals to B.
 */

package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubArraySumEqualsK {

    public static int solve(ArrayList<Integer> A, int B) { // TC : O(N) and SC : O(N)
    	
    	HashMap<Integer, Integer> hashMap = new HashMap<>();
    	hashMap.put(0, 1);
    	
    	int runSum = 0;
    	int count = 0;
    	
    	for (int i=0; i<A.size(); i++) {
    		runSum += A.get(i);
    		if (hashMap.containsKey(runSum-B)) {
    			count += hashMap.get(runSum-B);
    		}	
    		if (hashMap.containsKey(runSum)) {
    			int prevVal = hashMap.get(runSum);
    			hashMap.put(runSum, prevVal+1);
    		} else {
    			hashMap.put(runSum, 1);
    		}
    	}
    	return count;
    }
    
	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 0, 1));
		int B = 1;
		
		int ans = solve(A,B);
		System.out.println(ans);
	}

}
