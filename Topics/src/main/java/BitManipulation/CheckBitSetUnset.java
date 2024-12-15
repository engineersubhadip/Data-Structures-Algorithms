package BitManipulation;

public class CheckBitSetUnset {
	
	static boolean checkBit(int N, int bit) {
		if ((N & (1 << bit)) == 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		int N = 12;
		
		boolean result = checkBit(N, 3);
		
		System.out.println(result);
	}
}
