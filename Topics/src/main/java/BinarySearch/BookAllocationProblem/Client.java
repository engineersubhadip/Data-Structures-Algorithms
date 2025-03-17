package BinarySearch.BookAllocationProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
	
	static long getStudentCount(ArrayList<Integer> arr, long tarPageCount) {
		int totalStudent = 1;
		int currWorkLoad = 0;
		for (int i=0; i<arr.size(); i++) {
			if (currWorkLoad + arr.get(i) <= tarPageCount) {
				currWorkLoad += arr.get(i);
			} else {
				totalStudent += 1;
				currWorkLoad = arr.get(i);
			}
		}
		return totalStudent;
	}
	
	public static int books(ArrayList<Integer> arr, int B) {
		
		if (B > arr.size()) {
			return -1;
		}
		
		long studentCount = B;
		
		long maxEle = Long.MIN_VALUE;
		for (int i=0; i<arr.size(); i++) {
			maxEle = Math.max(maxEle, (long)arr.get(i));
		}
		
		long sum = 0;
		for (int i=0; i<arr.size(); i++) {
			sum += arr.get(i);
		}
		
		long left = maxEle;
		long right = sum;
		long ans = -1L;
		
		while (left <= right) {
			long mid = left + ((right - left)/2); // page count
			long actualStudentCount = getStudentCount(arr, mid);
			if (actualStudentCount <= studentCount) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (int)ans;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 15, 78));
		int B = 4;
		
		int ans = books(arr, B);
		System.out.println(ans);
	}

}
