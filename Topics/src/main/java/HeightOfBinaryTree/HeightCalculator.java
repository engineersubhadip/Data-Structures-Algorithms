package HeightOfBinaryTree;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class HeightCalculator implements Callable<Integer>{

	Node root;
	ExecutorService es;
	
	public HeightCalculator(Node root, ExecutorService es) {
		this.root = root;
		this.es = es;
	}
	
	public Integer call() throws Exception {
		if (this.root == null) {
			return 0;
		}
		
		Node leftSubTree = this.root.left;
		Node rightSubTree = this.root.right;
		
		HeightCalculator task1 = new HeightCalculator(leftSubTree, this.es);
		HeightCalculator task2 = new HeightCalculator(rightSubTree, this.es);
		
		Future<Integer> leftAns =  this.es.submit(task1);
		Future<Integer> rightAns =  this.es.submit(task2);
		
		int leftHeight = leftAns.get();
		int rightHeight = rightAns.get();
		
		return Math.max(leftHeight, rightHeight)  + 1;
	}

}
