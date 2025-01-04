package MultiThreading.Tree.CountTreeNode;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class NodeCounter implements Callable<Integer> {

	private TreeNode root;
	private ExecutorService es;
	
	public NodeCounter(TreeNode root, ExecutorService es) {
		this.root = root;
		this.es = es;
	}

	@Override
	public Integer call() throws Exception {
		if (this.root == null) {
			return 0;
		}
		
		TreeNode leftTree = root.left;
		TreeNode rightTree = root.right;
		
//		Creating the task :-
		NodeCounter leftTreeTask = new NodeCounter(leftTree, this.es);
		NodeCounter rightTreeTask = new NodeCounter(rightTree, this.es);
		
//		Submitting the task to the executor service :-
		
		Future<Integer> leftFuture =  this.es.submit(leftTreeTask);
		Future<Integer> rightFuture = this.es.submit(rightTreeTask);
		
		return leftFuture.get() + rightFuture.get() + 1;
	}
}
