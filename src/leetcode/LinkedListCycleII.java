package leetcode;


public class LinkedListCycleII {
	/**
	 * 解题关键在于，得出结论:在第一次相遇时slow指针没有完整走完圈
	 * 
	 * 
	 */
	public ListNode detectCycle(ListNode head)
	{
		ListNode slow = head,fast = head;
		do
		{
			if(slow != null)
				slow = slow.next;
			if(fast != null)
				fast = fast.next;
			if(fast != null)
				fast = fast.next;
		}
		while(slow != null && fast != null && slow != fast);
		if(fast == null)
			return null;
		else
		{
			slow = head;
			while(slow != fast)
			{
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
		
	}

}
