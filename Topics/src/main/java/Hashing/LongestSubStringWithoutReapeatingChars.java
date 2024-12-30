package Hashing;

import java.util.HashMap;

public class LongestSubStringWithoutReapeatingChars {

	public static int lengthOfLongestSubstring(String A) {
		
		if (A.length() == 1) {
			return 1;
		}
		
		HashMap<Character, Integer> hashMap = new HashMap<>();
		int left = 0;
		int right = 0;
		int maxLen = 1;
		while (right < A.length()) {
			char currChar = A.charAt(right);
			
			if (hashMap.containsKey(currChar)) {
				int prevVal = hashMap.get(currChar);
				hashMap.put(currChar, prevVal+1);
			} else {
				hashMap.put(currChar, 1);
			}
			
			while (left <= right && hashMap.get(currChar) > 1) {
				char leftChar = A.charAt(left);
				hashMap.put(leftChar, hashMap.get(leftChar)-1);
				if (hashMap.get(leftChar) == 0) {
					hashMap.remove(leftChar);
				}
				left ++;
			}
			
			if (left <= right) {
				int runLen = right - left + 1;
				maxLen = Math.max(maxLen, runLen);
			}
			
			right ++;
		}
		return maxLen;
	}

	public static void main(String[] args) {
		
		String A = "AaaA";
		
		System.out.println(lengthOfLongestSubstring(A));
	}
}
