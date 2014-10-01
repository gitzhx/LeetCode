package leetcode;

//class ListNode {
//	int val;
//	ListNode next;
//	ListNode(int x)
//	{
//		val = x;
//		next = null;
//	}
//}


public class LinkedListCycle {
	public boolean hasCycle(ListNode head)
	{
		ListNode fast = head,slow = head;
		do
		{
			if(slow != null)
				slow = slow.next;
			if(fast != null)
				fast = fast.next;
			if(fast != null)
				fast = fast.next;
		}
		while(fast != null && slow != null && fast != slow);
		if(fast != null && slow != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
