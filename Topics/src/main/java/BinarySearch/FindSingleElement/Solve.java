package BinarySearch.FindSingleElement;

import java.util.ArrayList;
import java.util.Arrays;

public class Solve {
	
	static int getSingleElement (ArrayList<Integer> A) {
		int start = 0;
		int end = A.size()-1;
		
		while (start <= end) {
			int mid = (start + (end - start)/2);
			
			if ((mid == 0 || A.get(mid) != A.get(mid-1)) && (mid == A.size()-1 || A.get(mid) != A.get(mid+1))) {
				return A.get(mid);
			}

			if (mid == 0 || A.get(mid) != A.get(mid-1)) {
				if (mid % 2 == 1) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (mid == A.size()-1 || A.get(mid) != A.get(mid+1)) {
				if (mid % 2 == 1) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(13,13,21,21,27,50,50,102,102,108,108,110,110,117,117,120,120,123,123,124,124,132,132,164,164,166,166,190,190,200,200,212,212,217,217,225,225,238,238,261,261,276,276,347,347,348,348,386,386,394,394,405,405,426,426,435,435,474,474,493,493));
		
		int ans = getSingleElement (A);
		
		System.out.println(ans);
	}

}
