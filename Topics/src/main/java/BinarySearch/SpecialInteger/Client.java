package BinarySearch.SpecialInteger;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
	
	static long getMaxSum(ArrayList<Integer> arr, int windowSize) { // TC : O(N) and SC : O(1)
		int start = 0;
		int end = windowSize-1;
//		System.out.println("Start : "+start+" End : "+end);
		long runSum = 0L;
		
		for (int i=start; i<=end; i++) {
			runSum += arr.get(i);
		}
		
		long maxSum = Long.MIN_VALUE;
		maxSum = Math.max(maxSum, runSum);
		
		start += 1;
		end += 1;
		
		while (end <= arr.size()-1) {
			runSum -= arr.get(start-1);
//			System.out.println("runSum1 : "+runSum);
			runSum += arr.get(end);
//			System.out.println("runSum2 : "+runSum);
//			System.out.println("Start1 : "+start+" End1 : "+end);
			maxSum = Math.max(maxSum, runSum);
			start += 1;
			end += 1;
		}
		return maxSum;
	}
	
	public static int solve(ArrayList<Integer> arr, int tarSum) { // TC : O(N * logN) and SC : O(1)
		long targetSum = tarSum;
//		BS on window size
		int left = 0;
		int right = arr.size();
		int ans = 0;
		
		while (left <= right) {
			int mid = left + ((right - left)/2);
//			System.out.println("Mid : "+mid);
			long currSum = getMaxSum(arr, mid);
			if (currSum <= targetSum) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
		int B = 130;
		
		int ans = solve(arr, B);
		System.out.println(ans);
	}

}
