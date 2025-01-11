package MultiThreading.BinaryTreeHeight;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(9);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println("Computing .......................");
		
		ExecutorService es = Executors.newCachedThreadPool();
		
		captureTreeHeight task = new captureTreeHeight(root, es);
		
		Future<Integer> promise = es.submit(task);
		
		int ans = 0;
		
		try {
			ans = promise.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("Tree Height "+ans);
		es.shutdown();
	}
}
