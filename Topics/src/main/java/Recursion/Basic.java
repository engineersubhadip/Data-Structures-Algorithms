package Recursion;
// Print "hello world" 5 times
public class Basic {
	
	static void printString(int N) {
		if (N == 0) {
			return;
		}
		System.out.println("Hello World");
		printString(N-1);
	}
	
	public static void main(String[] args) {
		printString(6);
	}

}
