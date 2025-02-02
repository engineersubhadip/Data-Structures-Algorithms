package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WaveArray {

	public static void main(String[] args) {
		
		List<Integer> arr = Arrays.asList(5,1,3,2,4);
		
		Collections.sort(arr);

        for (int i=1; i<arr.size(); i++) {
            if (i % 2 == 1) {
                if (arr.get(i) > arr.get(i-1)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i-1));
                    arr.set(i-1, temp);
                }
            } else {
                if (arr.get(i-1) > arr.get(i)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i-1));
                    arr.set(i-1, temp);
                }
            }
        }

        System.out.println(arr);

	}

}
