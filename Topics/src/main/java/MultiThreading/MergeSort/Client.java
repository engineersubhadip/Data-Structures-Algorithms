package MultiThreading.MergeSort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

	public static void main(String[] args) {
		
		List<Integer> arr = Arrays.asList(12,13,22,9,8,13,1,8,7,44,37,21);
		System.out.println("Before Sorting "+arr);
		System.out.println("--------------------------------------------");
//		Identify the task that needs to be run on a seperate thread -> Done
//		Implement the task in the form of Class -> mergeSorter -> Done
//		Create the task
		
		ExecutorService es = Executors.newCachedThreadPool();
		
		MergeSorter task = new MergeSorter(arr, es);
		
		Future<List<Integer>> ans = es.submit(task);
		
		List<Integer> result = null;
		
		try {
			result = ans.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("After Sorting "+result);
		es.shutdown();
	}

}
