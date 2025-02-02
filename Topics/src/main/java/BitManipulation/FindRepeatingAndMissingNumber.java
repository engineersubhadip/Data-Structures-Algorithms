package BitManipulation;

import java.util.Arrays;
import java.util.List;

public class FindRepeatingAndMissingNumber {
	
	static boolean checkBit(int N, int bit) {
		if ((N & (1 << bit)) == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {

		List<Integer> arr = Arrays.asList(4, 3, 6, 2, 1, 1);

		int ans1 = 0;
		for (int i = 1; i <= arr.size(); i++) {
			ans1 ^= i;
		}

		int ans2 = 0;
		for (int i = 0; i < arr.size(); i++) {
			ans2 ^= arr.get(i);
		}

		int ans = ans1 ^ ans2;
		
		int bifIdx = -1;
		
		for (int i=0; i<=31; i++) {
			boolean status = checkBit(ans, i);
			if (status) {
				bifIdx = i;
				break;
			}
		}
		
		int res1 = 0; // set
		int res2 = 0; // unset
		
		for (int i=1; i<=arr.size(); i++) {
			boolean status = checkBit(i, bifIdx);
			if (status) {
				res1 ^= i;
			} else {
				res2 ^= i;
			}
		}
		
		for (int i=0; i<arr.size(); i++) {
			boolean status = checkBit(arr.get(i), bifIdx);
			if (status) {
				res1 ^= arr.get(i);
			} else {
				res2 ^= arr.get(i);
			}
		}
		
		int count1 = 0;
		int count2 = 0;
		
		for (int i=0; i<arr.size(); i++) {
			int currEle = arr.get(i);

			if (currEle == res1) {
				count1 += 1;
			} else if (currEle == res2) {
				count2 += 1;
			}
		}
		
		if (count2 == 0) {
			System.out.println("Missing number: "+res2);
			System.out.println("Repeating number: "+res1);
		} else {
			System.out.println("Missing number: "+res1);
			System.out.println("Repeating number: "+res2);
		}
	}

}
