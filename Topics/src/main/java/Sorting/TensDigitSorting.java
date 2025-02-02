package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
// TC : O(NlogN) and SC : O(1)
public class TensDigitSorting {
	
	static int capture10Digit(Integer a) {
		int res = Math.floorDiv(a, 10);
		return res%10;
	}
	
	public static void main(String[] args) {
		
		List<Integer> arr = Arrays.asList(2, 24, 22, 19);
		
		Collections.sort(arr, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				int val1 = capture10Digit(a);
				int val2 = capture10Digit(b);
				if (val1 < val2) {
					return -1;
				} else if (val2 < val1) {
					return 1;
				} else {
					if (a > b) {
						return -1;
					} else if (a < b) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		});
		
		System.out.println(arr);
	}
	
}
