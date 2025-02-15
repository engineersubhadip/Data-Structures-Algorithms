package Strings;
// TC : O(NXM) and SC : O(1)
public class L2108_First_PallindromicString {
	
	public static boolean checkPallindrome(String str) {
		if (str.length() == 1) {
			return true;
		}
		int start = 0;
		int end = str.length()-1;
		
		while (start < end) {
			char startChar = str.charAt(start);
			char endChar = str.charAt(end);
			if (startChar == endChar) {
				start += 1;
				end -= 1;
			}else {
				return false;
			}
		}
		return true;
	}
	
	public static String firstPalindrome(String[] words) {
		for (int i=0; i<words.length; i++) {
			boolean status = checkPallindrome(words[i]);
			if (status) {
				return words[i];
			}
		}
		return "";
    }
	
	public static void main(String[] args) {
		String[] words = {"def","ghi"};
		
		System.out.println(firstPalindrome(words));
	}

}
