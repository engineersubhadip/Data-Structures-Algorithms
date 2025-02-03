package HeightOfBinaryTree;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Node root = new Node(23);
		root.left = new Node(24);
		root.right = new Node(19);
		root.right.left = new Node(21);
		root.right.right = new Node(26);
		
		ExecutorService es = Executors.newCachedThreadPool();
		
		HeightCalculator task = new HeightCalculator(root, es);
		
		Future<Integer> ans =  es.submit(task);
		
		System.out.println(ans.get());
		
		es.shutdown();
	}

}
