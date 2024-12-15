package BitManipulation;

public class ToggleBit {

	public static void main(String[] args) {
		int N = 12;
		
		N = N ^ (1 << 2);
		
		System.out.println(N);

	}

}
