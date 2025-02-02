package Sorting;

import java.util.Arrays;
import java.util.List;

// TC : O(N) and SC : O(1) and Single Pass

public class DutchNationalFlag {

	public static void main(String[] args) {
		
		List<Integer> arr = Arrays.asList(0, 1, 2, 0, 1, 2);
		
		int low = 0;
		int mid = 0;
		int high = arr.size()-1;
		
		while (mid <= high) {
			if (arr.get(mid) == 0) {
				int temp = arr.get(low);
				arr.set(low, arr.get(mid));
				arr.set(mid, temp);
				low += 1;
				mid += 1;
			} else if (arr.get(mid) == 1) {
				mid += 1;
			} else {
				int temp = arr.get(high);
				arr.set(high, arr.get(mid));
				arr.set(mid, temp);
				high -= 1;
			}
		}
		
		System.out.println(arr);
	}

}
