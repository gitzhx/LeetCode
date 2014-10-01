package leetcode;

//class ListNode{
//	int val;
//	ListNode next;
//	ListNode(int x){val = x;next = null;}
//}
public class SortList {
	/**
	 *归并排序应用于链表，定义slow，fast两个指针可以方便找出链表的中间节点
	 *时间复杂度O(nlogn)
	 */
	public ListNode sortList(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		else
		{
			ListNode slow = head;
			ListNode fast = head;
			while(fast.next != null && fast.next.next != null)		//简洁，可读，这样前半部分>=后半部分
			{
				slow = slow.next;
				fast = fast.next.next;
			}
			ListNode n2 = sortList(slow.next);
			slow.next = null;
			ListNode n1 = sortList(head);
			ListNode result = mergeList(n1,n2);
			return result;
		}
	}
	
	private ListNode mergeList(ListNode n1,ListNode n2)
	{
		ListNode result = new ListNode(-1);
		ListNode tmp = result;
		while(n1 != null && n2 != null)
		{
			if(n1.val <= n2.val)
			{
				tmp.next = n1;
				tmp = tmp.next;
				n1 = n1.next;
			}
			else
			{
				tmp.next = n2;
				tmp = tmp.next;
				n2 = n2.next;
			}
		}
		while(n1 != null)
		{
			tmp.next = n1;
			tmp = tmp.next;
			n1 = n1.next;
		}
		while(n2 != null)
		{
			tmp.next = n2;
			tmp = tmp.next;
			n2 = n2.next;
		}
		tmp.next = null;
		return result.next;
	}
	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		ListNode result = new SortList().sortList(n1);
		while(result != null)
		{
			System.out.println(result.val);
			result = result.next;
		}
	}

}
