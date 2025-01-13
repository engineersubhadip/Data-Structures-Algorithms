package MultiThreading.SortLinkedList;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class LinkedListSorter implements Callable<ListNode>{
	
	private ListNode head;
	private ExecutorService es;
	
	public LinkedListSorter (ListNode head, ExecutorService es) {
		this.head = head;
		this.es = es;
	}
	
	ListNode getMid (ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	ListNode mergeLinkedList (ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(-99);
		ListNode tail = dummy;
		
		ListNode temp1 = head1;
		ListNode temp2 = head2;
		
		while (temp1 != null && temp2 != null) {
			if (temp1.data <= temp2.data) {
				tail.next = temp1;
				tail = tail.next;
				temp1 = temp1.next;
				tail.next = null;
			} else {
				tail.next = temp2;
				tail = tail.next;
				temp2 = temp2.next;
				tail.next = null;
			}
		}
		
		if (temp1 != null) {
			tail.next = temp1;
		}
		
		if (temp2 != null) {
			tail.next = temp2;
		}
		
		return dummy.next;
	}
	
	
	@Override
	public ListNode call() throws Exception {
		
		if (this.head == null || this.head.next == null) {
			return this.head;
		}
		
		ListNode midNode = getMid(this.head);
		ListNode secondHead = midNode.next;
		midNode.next = null;
		
//		At this point we have 2 separate LL, and we need to create 2 threads and assign the task
//		of sorting 2 linked lists to 2 threads.
//		So we need to execute certain task on a thread.
//		1. Identify the task to be executed on a separate thread :- Sort a Linked List
//		2. Implement the task in the form of Class :- Done (LinkedListSorter)
//		3. Create the task
		LinkedListSorter leftTask = new LinkedListSorter(this.head, this.es);
		LinkedListSorter rightTask = new LinkedListSorter(secondHead, this.es);
//		4. Submit the task to the Executor Service and capture the Promises
		Future<ListNode> leftPromise =  this.es.submit(leftTask);
		Future<ListNode> rightPromise =  this.es.submit(rightTask);
//		5. Block the invoking parent thread
		ListNode leftNode = leftPromise.get(); // sorted in nature
		ListNode rightNode = rightPromise.get(); // sorted in nature
//		6. Merge the 2 linked lists
		
		ListNode result = mergeLinkedList(leftNode, rightNode);
		
		return result;
		
	}

}
