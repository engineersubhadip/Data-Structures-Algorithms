package BitManipulation;

public class Leetcode2220_MinBitFlipsToConvertNumber {
	
	static boolean checkBit(int N, int bit) {
		if ((N & (1 << bit)) == 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int start = 3;
		int goal = 4;
		
		int count = 0;
		
		for (int i=0; i<=31; i++) {
			int currBit = i;
			boolean status1 = checkBit(start,currBit);
			boolean status2 = checkBit(goal,currBit);
			
			if (status1 != status2) {
				count ++;
			}
		}
		
		System.out.println(count);

	}

}
