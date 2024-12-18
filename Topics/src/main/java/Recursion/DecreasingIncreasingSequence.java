package Recursion;

public class DecreasingIncreasingSequence {
    
	public static String decreasingSeq(int A) {
		
		if (A == 1) {
			String ans = "1";
			return ans;
		}
		
		String result = decreasingSeq(A-1);
		String ans = A+" "+result;
		return ans;
	}
	
	public static String increasingSeq(int A) {
		if (A == 1) {
			String ans = "1";
			return ans;
		}
		String res = increasingSeq(A-1);
		String ans = res+" "+A;
		return ans;
	}
	
	public static void DecThenInc(int A) {
		
		String decSeq =  decreasingSeq(A);
		String incSeq = increasingSeq(A);
		
		String ans = decSeq+" "+incSeq;
		
		System.out.println(ans);
    }
	
	public static void main(String[] args) {
		
		int A = 4;
		
		DecThenInc(A);

	}

}
