package BinarySearch.FindPeakElement;

import java.util.ArrayList;
import java.util.Arrays;

public class Solve { // tc : O(logN) and sc : O(1)
	
	static int findPeak (ArrayList<Integer> A) {
		
		int start = 0;
		int end = A.size()-1;
		
		while (start <= end) {
			int mid = (start + (end - start)/2);
			
			if ((mid == 0 || A.get(mid) >= A.get(mid-1)) && (mid == A.size() - 1 || A.get(mid) >= A.get(mid+1))) {
				return A.get(mid);
			}
			if (mid == 0 || A.get(mid) >= A.get(mid-1)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
		
		int ans = findPeak(A);
		
		System.out.println(ans);
	}

}
