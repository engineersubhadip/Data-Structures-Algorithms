package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BthSmallestTriplet {
	
	static int getSum(ArrayList<Integer> arr, int tarSum) {
		int i = 0;
		int runCount = 0;
		
		while (i < arr.size()) {
			int j = i + 1;
			int k = arr.size()-1;
			while (j < k) {
				int runSum = arr.get(i) + arr.get(j) + arr.get(k);
				if (runSum <= tarSum) {
					runCount += (k - j);
					j += 1;
				} else {
					k -= 1;
				}
			}
			i += 1;
		}
		return runCount;
	}
	
	public static void main(String[] args) { // Final TC : O(N2 * logN) and SC : O(1)
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 5, 7, 3, 2));
		int tarEle = 9;
		Collections.sort(arr); // TC : O(NlogN) and SC : O(1)
		
		int left = arr.get(0) + arr.get(1) + arr.get(2);
		int right = arr.get(arr.size()-1) + arr.get(arr.size()-2) + arr.get(arr.size()-3);
		int ans = -1;
		
		while (left <= right) { // TC : O(logN * N2) and SC : O(1)
			int mid = left + ((right - left)/2);
			int tarCount = getSum(arr, mid);

			if (tarCount >= tarEle) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println("Target Element sum is : "+ ans);
	}

}
