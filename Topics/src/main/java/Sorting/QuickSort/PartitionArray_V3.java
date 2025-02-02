package Sorting.QuickSort;

import java.util.Arrays;
import java.util.List;
// SC : O(logN)
// TC : {Best Case -> NlogN; Worst Case -> N2}
public class PartitionArray_V3 {
	
	static int capturePivotPoint(List<Integer> arr, int start, int end) {
		int refEle = arr.get(start);
		int i = start + 1;
		int j = end;
		
		while (i <= j) {
			if (arr.get(i) <= refEle) {
				i += 1;
			} else if (arr.get(j) > refEle) {
				j -= 1;
			} else {
				int temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
				i += 1;
				j -= 1;
			}
		}
		
		int temp = arr.get(j);
		arr.set(j, refEle);
		arr.set(start, temp);
		return j;
	}
	
	static void quickSort(List<Integer>arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = capturePivotPoint(arr, start, end);
		quickSort(arr, start, pivot-1);
		quickSort(arr,pivot+1,end);
	}
	
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(54,26,93,17,77,31,44);
		
		quickSort(arr,0, arr.size()-1);
		
		System.out.println(arr);
	}
}
