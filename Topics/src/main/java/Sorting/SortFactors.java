package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortFactors {
	
    static int getFactorCount(Integer a) {
        int count = 0;
        for (int i=1; i*i<=a; i++) {
            if (a % i == 0) {
                if (i * i == a) {
                    count ++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
    
	public static void main(String[] args) {
		
		List<Integer> arr = Arrays.asList(6, 8, 9);
		
		Collections.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int factorA = getFactorCount(a);
                int factorB = getFactorCount(b);

                if (factorA < factorB) {
                    return -1;
                } else if (factorA > factorB) {
                    return 1;
                } else {
                    if (a < b) {
                        return -1;
                    } else if (a > b) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });
		
		System.out.println(arr);
	}

}
