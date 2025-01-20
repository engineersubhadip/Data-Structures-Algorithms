package MultiThreading.SumofLeftLeaves;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
//		1. Identify the task that needs to be run on a separate thread.
//		: The task is to find the sum of all the leftNodes in a Binary Tree.
		
//		2. Implement the task in the form of Class :- Adder
//		The task which we are executing on a seperate thread, does it needs to return something :- YES (int) -> Callable Interface
		
//		3. Create the task
		
//		4. Submit the task to the ExecutorService.
		
		ExecutorService es = Executors.newCachedThreadPool();
		
		Adder task = new Adder(root, es, false);
		
		Future<Integer> ans =  es.submit(task);
		
		try {
			System.out.println(ans.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		es.shutdown();
	}

}
