package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FrequencyOfEveryElement { // TC : O(N) and SC : O(N)

	public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		
		for (int i = 0; i<A.size(); i++) {
			if (hashMap.containsKey(A.get(i))) {
				int prevVal = hashMap.get(A.get(i));
				hashMap.put(A.get(i), prevVal+1);
			} else {
				hashMap.put(A.get(i), 1);
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i=0; i<B.size(); i++) {
			if (hashMap.containsKey(B.get(i))) {
				result.add(hashMap.get(B.get(i)));
			} else {
				result.add(0);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 5, 9, 2, 8));
		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(3, 2));
		
		ArrayList<Integer> result = solve(A,B);
		
		System.out.println(result);
	}

}
;