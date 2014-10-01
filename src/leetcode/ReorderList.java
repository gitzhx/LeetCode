package leetcode;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

//class ListNode{
//	int val;
//	ListNode next;
//	public void ListNode(int x)
//	{
//		this.val = x;
//		this.next = null;
//	}
//}

public class ReorderList {
	/**
	 *使用一个栈和一个队列，时间复杂度为O(n)
	 */
	public void reorderList(ListNode head)
	{
		//TODO:笨了，用一个双向队列不就可以了，简洁直观，V2中重写
		Stack<ListNode> stack = new Stack<>();				//栈存取全部对象
		Queue<ListNode> queue = new LinkedList<>();			//队列存取全部对象	
		ListNode result = new ListNode(-1);
		ListNode tmp = result;
		int index = 0;
		while(head != null)
		{
			queue.offer(head);
			stack.push(head);
			head = head.next;
			index++;
		}
		for(int i = 0;i < index;i++)
		{
			if(i % 2 == 0)
			{
				tmp.next = queue.poll();
				tmp = tmp.next;
			}
			else
			{
				tmp.next = stack.pop();
				tmp = tmp.next;
			}
		}
		tmp.next = null;
	}
	
	public void reorderListV2(ListNode head)
	{
		Deque<ListNode> queue = new LinkedList<>();
		ListNode result = new ListNode(-1);
		int index = 0;
		while(head != null)
		{
			queue.offerLast(head);
			head = head.next;
		}
		while(!queue.isEmpty())
		{
			if(index % 2 == 0)
				result.next = queue.pollFirst();
			else
				result.next = queue.pollLast();
			result = result.next;
			index++;
		}
		result.next = null;
	}
	
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		new ReorderList().reorderListV2(n1);
		while (n1 != null) {
			System.out.println(n1.val);
			n1 = n1.next;
		}
	}

}
