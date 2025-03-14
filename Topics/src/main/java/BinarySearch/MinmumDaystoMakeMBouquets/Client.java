package BinarySearch.MinmumDaystoMakeMBouquets;

public class Client {
	
	static int getBCount(int[]arr, int refDay, int flowerCount) {
		int count = 0;
		int runCount = 0;
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i] <= refDay) {
				runCount += 1;
			} else {
				int runAns = (runCount / flowerCount);
				count += runAns;
				runCount = 0;
			}
		}
		
		int runAns = (runCount / flowerCount);
		count += runAns;
		return count;
	}
	
    public static int minDays(int[] arr, int m, int k) {
    	
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        for (int i=0; i<arr.length; i++) {
            left = Math.min(left, arr[i]);
            right = Math.max(right, arr[i]);
        }

        int ans = -1;

        while (left <= right) {
            int mid = left + ((right - left)/2);
            int bCount = getBCount(arr, mid, k);
            if (bCount >= m) {
            	ans = mid;
            	right = mid - 1;
            } else {
            	left = mid + 1;
            }
        }
        
    	return ans;
    }
    
	public static void main(String[] args) { // TC : O(N * log (max-min)) and SC : O(1)
		
		int arr[] = {7,7,7,7,12,7,7};
		int m = 2;
		int k = 3;
		
		int ans = minDays(arr, m, k);
		System.out.println(ans);
	}

}
