package BitManipulation;

public class SetTheRightMostUnsetBit {
	
	static boolean checkBit(int N, int bit) {
		if ((N & (1 << bit)) == 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		int N = 15;
		
		for (int i=0; i<=31; i++) {
			int currBit = i;
			boolean status = checkBit(N, currBit);
			if (!status) {
				N = N ^ (1 << currBit);
				break;
			}
		}
		
		System.out.println(N);

	}

}
