package BinarySearch.FloorAndCeil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRange {
	
	static int getFloor (final List<Integer> A, int tar) {
		int start = 0;
		int end = A.size()-1;
		int ans = -1;
		
		while (start <= end) {
			int mid = (start + (end - start)/2);
			if (A.get(mid) == tar) {
				ans = mid;
				end = mid - 1;
			} else if (A.get(mid) < tar) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return ans;
	}
	
	static int getCeil (final List<Integer> A, int tar) {
		int start = 0;
		int end = A.size()-1;
		int ans = -1;
		
		while (start <= end) {
			int mid = (start + (end - start)/2);
			if (A.get(mid)  == tar) {
				ans = mid;
				start = mid + 1;
			} else if (A.get(mid) > tar) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		final List<Integer> A = Arrays.asList(5, 17, 100, 111);
		int B = 3;
		
		int floor = getFloor(A, B);
		int ceil = getCeil(A, B);
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(floor);
		arr.add(ceil);
		
		System.out.println(arr);
	}

}
