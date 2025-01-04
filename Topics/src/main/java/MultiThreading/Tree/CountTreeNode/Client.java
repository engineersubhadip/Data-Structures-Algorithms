package MultiThreading.Tree.CountTreeNode;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode (2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		
		ExecutorService es = Executors.newCachedThreadPool();
		NodeCounter task = new NodeCounter(root, es);
		
		Future<Integer> futureAns =  es.submit(task);
		
		System.out.println("Number of Nodes "+futureAns.get());
		
		es.shutdown();
	}
}
