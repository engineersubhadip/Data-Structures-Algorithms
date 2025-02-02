package Sorting.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArray_V1 {
	
	static int[] partitionArray(List<Integer> arr) {
		
		int[] res = new int[arr.size()];
		int start = 0;
		int end = res.length-1;
		int refEle = arr.get(0);
		
		for (int i=1; i<arr.size(); i++) {
			int currEle = arr.get(i);
			if (currEle <= refEle) {
				res[start] = currEle;
				start += 1;
			} else {
				res[end] = currEle;
				end -= 1;
			}
		}
		res[start] = refEle;
		return res;
	}
	
	public static void main(String[] args) {
		
		List<Integer> arr = Arrays.asList(54,26,93,17,77,31,44);
		
		int[]ans = partitionArray(arr);
		ArrayList<Integer> res = new ArrayList<>();
		for (int i=0; i<ans.length; i++) {
			res.add(ans[i]);
		}
		
		System.out.println(res);
	}

}
