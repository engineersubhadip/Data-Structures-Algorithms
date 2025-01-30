package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(1, 2, 2, 3, 1);

		HashSet<Integer> hashSet = new HashSet<>();
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		for (int i=0; i<arr.size(); i++) {
			if (hashSet.contains(arr.get(i)) == false) {
				ans.add(arr.get(i));
				hashSet.add(arr.get(i));
			}
		}
		
		System.out.println(ans);
	}

}
