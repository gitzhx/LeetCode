package zhx;

/**
 *class ListNode{
 *int val;
 *ListNode next;
 *ListNode(int x){val = x;next = null;}
 *} 
 */

public class RemoveDuplicatesFromSortedListII {
	/**
	 *尾部插入的方式重构链表，节点选择时判断该节点值和pre和post都不相同才选择
	 *时间复杂度O(n) 
	 */
	public ListNode deleteDuplicates(ListNode head)
	{
		ListNode result = new ListNode(-1);
		ListNode last = result;
		ListNode pre = null;
		ListNode post;
		while(head != null)
		{
			post = head.next;
			if(pre != null && pre.val == head.val || post != null && post.val == head.val)
			{
				pre = head;
				head = head.next;
			}
			else
			{
				last.next = head;
				last = last.next;
				pre = head;
				head = head.next;
			}
		}
		last.next = null;
		return result.next;
	}
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		ListNode result = new RemoveDuplicatesFromSortedListII().deleteDuplicates(n1);
		while(result != null)
		{
			System.out.println(result.val);
			result = result.next;
		}
	}

}
