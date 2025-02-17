/*
You are given a string s consisting of digits and an integer k.

A round can be completed if the length of s is greater than k. In one round, do the following:

Divide s into consecutive groups of size k such that the first k characters are in the first group, 
the next k characters are in the second group, and so on. Note that the size of the last group can be smaller than k.
Replace each group of s with a string representing the sum of all its digits. For example, "346" is replaced with "13" because 3 + 4 + 6 = 13.
Merge consecutive groups together to form a new string. If the length of the string is greater than k, repeat from step 1.

Return s after all rounds have been completed.
 */

package Strings;

public class L2243_CalculateDigitSum {
	static String ansVal = ""; 
	
	public static int getSize(int start, int end) {
		return end - start + 1;
	}
	
 	public static int getSum(String str) {
		int total = 0;
		for (int i=0; i<str.length(); i++) {
			char currChar = str.charAt(i);
			String currStr = ""+currChar;
			int currNumber = Integer.parseInt(currStr);
			total += currNumber;
		}
		return total;
	}
	
	public static void getStringSum(String str, int tarSize, int start, int end) {
		if (start >= str.length()) {
			return;
		}
		int tempStart = start;
		int tempEnd = -1;
		if (end >= str.length()) {
			tempEnd = str.length()-1;
		} else {
			tempEnd = end;
		}
		String tempStr = "";
		while (tempStart <= tempEnd) {
			char currChar = str.charAt(tempStart);
			tempStr += currChar;
			tempStart += 1;
		}
		int tempSum = getSum(tempStr);
		ansVal += tempSum;
		getStringSum(str, tarSize, tempStart, tempStart+tarSize-1);
	}
	
	public static void main(String[] args) {
		String str = "00000000";
		int k = 3;
		
		getStringSum(str,k,0,k-1);
		
		while (true) {
			if (ansVal.length() > k) {
				String temp = ansVal;
				ansVal = "";
				getStringSum(temp,k,0,k-1);
			}else {
				break;
			}
		}
		
		System.out.println(ansVal);

	}

}
