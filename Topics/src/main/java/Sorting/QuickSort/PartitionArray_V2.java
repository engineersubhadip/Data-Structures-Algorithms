package Sorting.QuickSort;

import java.util.Arrays;
import java.util.List;

public class PartitionArray_V2 {
	
	static void partitionArr(List<Integer> arr) {
		int refEle = arr.get(0);
		int start = 1;
		int end = arr.size()-1;
		
		while (start <= end) {
			if (arr.get(start) <= refEle) {
				start += 1;
			} else if (arr.get(end) > refEle) {
				end -= 1;
			} else {
				int temp = arr.get(start);
				arr.set(start, arr.get(end));
				arr.set(end, temp);
				start += 1;
				end -= 1;
			}
		}
		
		int temp = arr.get(end);
		arr.set(end, refEle);
		arr.set(0, temp);
	}
	
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(54,26,93,17,77,31,44);
		
		partitionArr(arr);
		
		System.out.println(arr);
	}
}
