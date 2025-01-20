package MultiThreading.SumofLeftLeaves;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Adder implements Callable<Integer> {
	
	public TreeNode root;
	public ExecutorService es;
	public boolean flag;
	
	public Adder (TreeNode root, ExecutorService es, boolean flag) {
		this.root = root;
		this.es = es;
		this.flag = flag;
	}

	@Override
	public Integer call() throws Exception {
		
		if (root == null) {
			return 0;
		}
		if (root.left == null  && root.right == null && flag == true) {
			return root.val;
		}
		if (root.left == null && root.right == null && flag == false) {
			return 0;
		}
		
//		At this point of time, we should be sending the leftSubtree to t1 and rightSubtree to t2.
//		Meaning we are supposed to execute 2 tasks to 2 seperate threads.
//		1. Identify the task :-
//		The task is to calculate the left leaves node values.
//		Adder Class is taking care of that.
		
		Adder leftTask = new Adder(root.left, this.es, true);
		Adder rightTask = new Adder(root.right, this.es, false);
		
//		Submit the task to the Executor Service
		
		Future<Integer> leftPromise =  this.es.submit(leftTask);
		Future<Integer> rightPromise =  this.es.submit(rightTask);
		
		Integer leftAns = leftPromise.get();
		Integer rightAns = rightPromise.get();
		
		return leftAns + rightAns;
	}
}
