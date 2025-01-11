package MultiThreading.BinaryTreeHeight;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class captureTreeHeight implements Callable<Integer>{
	
	private TreeNode root;
	private ExecutorService es;
	
	public captureTreeHeight (TreeNode root, ExecutorService es) {
		this.root = root;
		this.es = es;
	}
	
	@Override
	public Integer call() throws Exception {
		if (this.root == null) {
			return 0;
		}
		
		TreeNode leftSubTree = this.root.left;
		TreeNode rightSubTree = this.root.right;
		
//		At this point we should create 2 threads and assign the task of leftSubTree and rightSubTree Height
		captureTreeHeight leftTask = new captureTreeHeight (leftSubTree, this.es);
		captureTreeHeight rightTask = new captureTreeHeight (rightSubTree, this.es);
		
		Future<Integer> leftPromise = this.es.submit(leftTask);
		Future<Integer> rightPromise = this.es.submit(rightTask);
		
		int leftHeight = leftPromise.get();
		int rightHeight = rightPromise.get();
		
		return Math.max(leftHeight, rightHeight) + 1;
	}

}
