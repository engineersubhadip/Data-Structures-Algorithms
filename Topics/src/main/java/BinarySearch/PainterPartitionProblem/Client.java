package BinarySearch.PainterPartitionProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
	
	static int workerCount (ArrayList<Long> arr, long refTime) { // TC : O(N) and SC : O(1)
		
		int workerCount = 1;
		long currTime = 0;
		for (int i=0; i<arr.size(); i++) {
			if (currTime+arr.get(i) <= refTime) {
				currTime += arr.get(i);
			} else {
				workerCount += 1;
				currTime = arr.get(i);
			}
		}
		return workerCount;
	}
	
	public static int paint(int A, int B, ArrayList<Integer> C) { // TC : O(N * log[sumTotal - maxTime]) and SC : O(N) 
		ArrayList<Long> arr = new ArrayList<>();
		for (int i = 0; i < C.size(); i++) {
			arr.add(((long)C.get(i) * (long)B));
		}

		long maxTime = Long.MIN_VALUE;
		long sumTotal = 0;
		for (int i = 0; i < arr.size(); i++) {
			maxTime = Math.max(maxTime, arr.get(i));
			sumTotal += arr.get(i);
		}
		
		long left = maxTime;
		long right = sumTotal;
		long ans = -1L;
		
		while (left <= right) { // TC : O(N * log[sumTotal - maxTime]) and SC : O(N) 
			long mid = left + ((right - left)/2); // In this time how many workers do I need to finish the job ?
			int reqdWorkerCount = workerCount(arr, mid);
			if (reqdWorkerCount <= A) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (int)ans;
	}

	public static void main(String[] args) {
		ArrayList<Integer> C = new ArrayList<>(Arrays.asList(1, 8, 11, 3));
		int A = 10;
		int B = 1;
		
		int ans = paint(A, B, C);
		System.out.println(ans);
	}

}
