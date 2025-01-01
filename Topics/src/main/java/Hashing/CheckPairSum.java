/*
Given an Array of integers B, and a target sum A.
Check if there exists a pair (i,j) such that B[i] + B[j] = A and i!=j.
*/

package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CheckPairSum {

    public static int solve(int A, ArrayList<Integer> B) { // TC : O(N) and SC : O(N)
    	
    	HashMap<Integer, Integer> hashMap = new HashMap<>();
    	
    	for (int i=0; i<B.size(); i++) {
    		int currEle = B.get(i);
    		if (hashMap.containsKey(currEle)) {
    			int prevVal = hashMap.get(currEle);
    			hashMap.put(currEle, prevVal + 1);
    		} else {
    			hashMap.put(currEle, 1);
    		}
    	}
    	
    	for (int i=0; i<B.size(); i++) {
    		int currEle = B.get(i);
    		int tarEle = A - currEle;
    		
    		if (currEle != tarEle) {
    			if (hashMap.containsKey(tarEle) == true && hashMap.get(tarEle) > 0) {
    				return 1;
    			}
    		} else {
    			if (hashMap.get(tarEle) > 1) {
    				return 1;
    			}
    		}
    	}
    	
    	return 0;
    }
    
	public static void main(String[] args) {
		
		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(9, 10, 7, 10, 9, 1, 5, 1, 5));
		int A = 21;
		int ans = solve(A, B);
		
		System.out.println(ans);
	}

}
