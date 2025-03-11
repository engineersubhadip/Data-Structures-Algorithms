package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MedianOf2SortedArrays {
	
	public static int getMedian(ArrayList<Integer> arr1, ArrayList<Integer> arr2) { // TC : O(log(min(a,b))) and SC : O(1)
		if (arr1.size() > arr2.size()) {
			return getMedian(arr2, arr1);
		}
		int total = arr1.size() + arr2.size();
		int tarCount = total/2;
		
//		Left right to be applied on the smaller Array
		int left = 0;
		int right = arr1.size();
		
		while (left <= right) {
			int mid1 = left + ((right - left)/2);
			int mid2 = tarCount - mid1;
			
			int l1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1.get(mid1-1);
			int r1 = (mid1 == arr1.size()) ? Integer.MAX_VALUE : arr1.get(mid1);
			int l2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2.get(mid2-1);
			int r2 = (mid2 == arr2.size()) ? Integer.MAX_VALUE : arr2.get(mid2);
			
			if (l1 <= r2 && l2 <=r1) {
				if (total % 2 == 0) {
					return (Math.max(l1,l2) + Math.min(r1, r2))/2; 	
				} else {
					return Math.min(r1, r2);
				}
			}
			
			if (l1 > r2) {
				right = mid1 - 1;
			} else {
				left = mid1 + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(2,3,6,15));
		ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1,3,4,7,10,12));
		
		int ans = getMedian(arr1, arr2);
		System.out.println("Median is : "+ans);
	}

}
