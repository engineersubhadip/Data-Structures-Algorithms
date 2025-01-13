package MultiThreading.SortLinkedList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(12,13,8,9,7,22,15,6,3);
		
		ListNode head = new ListNode(arr.get(0));
		ListNode tail = head;
		
		for (int i=1; i< arr.size(); i++) {
			ListNode node = new ListNode(arr.get(i));
			tail.next = node;
			tail = tail.next;
			tail.next = null;
		}
		
		System.out.println("******** Before Sorting ***********");
		
		ListNode temp1 = head;
		
		while (temp1 != null) {
			System.out.print(temp1.data+" ");
			temp1 = temp1.next;
		}
		
		System.out.println("\n");
		
//		1. Identify the task to be run on separate thread :- Done
//		2. Implement the task in the form of Class :- Done
//		3. Create the task :-
		ExecutorService es = Executors.newCachedThreadPool();
		
		LinkedListSorter task = new LinkedListSorter(head, es);
		
//		4. Submit the task to the Executor Service :-
		
		Future<ListNode> ans =  es.submit(task);
		
//		5. Block the main thread until the Promise resolves.
		
		ListNode result = null;
		
		try {
			result = ans.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("*********** After Sorting **********");
		
		ListNode temp2 = result;
		
		while (temp2 != null) {
			System.out.print(temp2.data+" ");
			temp2 = temp2.next;
		}
		
		es.shutdown();
	}

}
