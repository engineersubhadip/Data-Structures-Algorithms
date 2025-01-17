package BinarySearch.SortedInsertPosition;

import java.util.ArrayList;
import java.util.Arrays;

public class Solve {
	
	static int getCeil(ArrayList<Integer> arr, int tar) {
		int ans = arr.size();
		int left = 0;
		int right = arr.size()-1;
		while (left <= right) {
			int mid = (left + (right - left)/2);
			if (arr.get(mid) >= tar) {
				ans = mid;
				right = mid - 1;;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 4, 9));
		int B = 3;
		
		int ans = getCeil(arr, B);
		
		System.out.println(ans);

	}

}
