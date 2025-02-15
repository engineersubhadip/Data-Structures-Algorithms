/*
Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 
and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, 
do nothing.
For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
Return the resulting string.
 */

package Strings;

import java.util.Arrays;

public class L2000_ReversePrefixOfWord {
	
	public static String revString(String str, int start, int end) {
		String[] res = str.split("");
		
		while (start < end) {
			String temp = res[start];
			res[start] = res[end];
			res[end] = temp;
			
			start += 1;
			end  -= 1;
		}
		
		String ans = String.join("", Arrays.asList(res));
		return ans;
	}
	
	public static int getFirstOcc(String str, char tar) {
		int ans = -1;
		for (int i=0; i<str.length(); i++) {
			char currChar = str.charAt(i);
			if (currChar == tar) {
				return i;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String word = "abcd";
		String ch = "z";
		char tarChar = ch.charAt(0);
		
		int tarIdx = getFirstOcc(word, tarChar);
		
		if (tarIdx == -1) {
			System.out.println(word);
		}
		
		String ans = revString(word, 0, tarIdx);
		
		System.out.println(ans);
	}

}
