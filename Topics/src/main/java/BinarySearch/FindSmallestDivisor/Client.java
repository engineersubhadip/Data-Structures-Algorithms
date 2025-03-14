package BinarySearch.FindSmallestDivisor;

public class Client {
	
	static int getSum(int[] arr, int refSum) { // TC : O(N) and SC : O(1)
		long total = 0;
		for (int i=0; i<arr.length; i++) {
			double ans = Math.ceil((double)(arr[i])/ (double)refSum);
			total += ans;
		}
		return (int)total;
	}
	
    public static int smallestDivisor(int[] arr, int tar) { // TC : O(N * log[max - min]) and SC : O(1)
    	int left = 1;
    	int right = Integer.MIN_VALUE;
    	
    	for (int i=0; i<arr.length; i++) {
    		right = Math.max(right, arr[i]);
    	}
    	
    	int ans = -1;
    	
    	while (left <= right) {
    		int mid = left + ((right - left)/2);
    		int currSum = getSum(arr, mid);
    		if (currSum <= tar) {
    			ans = mid;
    			right = mid - 1;
    		} else {
    			left = mid + 1;
    		}
    	}
    	
        return ans;
    }
    
	public static void main(String[] args) { // TC : O(N * log[max - min]) and SC : O(1)
		int[] arr = {21212,10101,12121};
		int tar = 1000000;
		
		int ans = smallestDivisor(arr, tar);
		System.out.println(ans);

	}

}
