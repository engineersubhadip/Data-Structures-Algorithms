package MultiThreading.MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>>{
	
	private List<Integer> arr;
	private ExecutorService es;
	
	public MergeSorter(List<Integer> arr, ExecutorService es) {
		this.arr = arr;
		this.es = es;
	}
	
	public List<Integer> mergeArr(List<Integer> leftArr, List<Integer> rightArr) {
		List<Integer> ans = new ArrayList<>();
		int i=0, j=0;
		
		while (i < leftArr.size() && j < rightArr.size()) {
			if (leftArr.get(i) <= rightArr.get(j)) {
				ans.add(leftArr.get(i));
				i ++;
			} else {
				ans.add(rightArr.get(j));
				j ++;
			}
		}
		
		while (i < leftArr.size()) {
			ans.add(leftArr.get(i));
			i ++;
		}
		
		while (j < rightArr.size()) {
			ans.add(rightArr.get(j));
			j ++;
		}
		
		return ans;
	}
	
	@Override
	public List<Integer> call() throws Exception {
		
		if (this.arr.size() <= 1) {
			return this.arr;
		}
		
		int mid = arr.size()/2;
		
		List<Integer> leftArr = new ArrayList<>();
		List<Integer> rightArr = new ArrayList<>();
		
		for (int i=0; i<mid; i++) {
			leftArr.add(this.arr.get(i));
		}
		
		for (int i=mid; i < this.arr.size(); i++) {
			rightArr.add(this.arr.get(i));
		}
		
//		At this point we want to create 2 threads and sort left and right Arr. -> Execute a task on thread
//		Identify the task :- Done
//		Implement the task in the form of Class -> Done (MergeSorter)
//		Create the task :-
		MergeSorter leftTask = new MergeSorter(leftArr, this.es);
		MergeSorter rightTask = new MergeSorter(rightArr, this.es);
//		Submit the task to the Executor Service :-
		Future<List<Integer>> leftAns =  es.submit(leftTask);
		Future<List<Integer>> rightAns = es.submit(rightTask);
//		Capture from the Promise and block the invoking thread
		List<Integer> leftArrAns = leftAns.get();
		List<Integer> rightArrAns = rightAns.get();
		
		List<Integer> ans = mergeArr(leftArrAns, rightArrAns);
		
		return ans;
	}

}
