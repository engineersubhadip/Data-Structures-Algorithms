package BitManipulation;

public class TwoNumbersWithOddOccurences {
	
	static boolean checkBit(int N, int bit) {
		if ((N & (1 << bit)) == 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {4, 2, 4, 5, 2, 3, 3, 1};
		
		int ans = 0;
		
		for (int i=0; i<arr.length; i++) {
			ans ^= arr[i];
		}
		
		int bifIdx = -1;
		
		for (int i=0; i<=31; i++) {
			int currBit = i;
			boolean status = checkBit(ans, currBit);
			if (status) {
				bifIdx = currBit;
				break;
			}
		}
		
		int ans1 = 0; // set
		int ans2 = 0; //unset
		
		for (int i=0; i<arr.length; i++) {
			boolean status = checkBit(arr[i], bifIdx);
			if (status) {
				ans1 ^= arr[i];
			}else {
				ans2 ^= arr[i];
			}
		}
		
		if (ans1 > ans2) {
			int[] res1 = {ans1, ans2};
			System.out.println(res1);
		}else {
			int[] res1 = {ans2, ans1};
			System.out.println(res1);
		}
	}

}
