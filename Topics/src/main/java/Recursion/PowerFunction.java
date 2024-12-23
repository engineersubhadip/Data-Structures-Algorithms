package Recursion;

public class PowerFunction {
	
	static int recursion (int base, int power) {
		
		if (power == 0) {
			return 1;
		}
		if (power == 1) {
			return base;
		}
		
		int temp = recursion(base, power/2);
		
		if (power % 2 == 0) {
			return temp * temp;
		} else {
			return base * temp * temp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = recursion(5,4);
		
		System.out.println(ans);
	}

}
