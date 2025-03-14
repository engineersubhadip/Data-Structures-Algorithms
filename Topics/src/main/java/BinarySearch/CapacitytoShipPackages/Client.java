package BinarySearch.CapacitytoShipPackages;

public class Client {
	
	static int getDay(int[] arr, int refWeight) { // TC : O(N) and SC : O(1)
		int count = 1;
		int runWeight = 0;
		for (int i=0; i<arr.length; i++) {
			if (runWeight+arr[i] <= refWeight) {
				runWeight += arr[i];
			} else {
				count += 1;
				runWeight = arr[i];
			}
		}
		return count;
	}
	
	public static int shipWithinDays(int[] arr, int tarDays) { // TC : O(N * log[sum - maxEle]) and SC : O(1)
		
		int maxEle = Integer.MIN_VALUE;
		int sum  = 0;
		for (int i=0; i<arr.length; i++) {
			maxEle = Math.max(maxEle, arr[i]);
			sum += arr[i];
		}
		
		int left = maxEle;
		int right = sum;
		int ans = sum;
		
		while (left <= right) {
			int mid = left + ((right - left)/2);
			int dayCount = getDay(arr, mid);
			if (dayCount <= tarDays) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) { // TC : O(N * log[sum - maxEle]) and SC : O(1)
		int[] arr = {1,2,3,1,1};
		int tarDays = 4;
		
		int ans = shipWithinDays(arr, tarDays);
		System.out.println(ans);
	}

}
