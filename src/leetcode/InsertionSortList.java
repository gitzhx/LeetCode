package leetcode;

//class ListNode{
//	int val;
//	ListNode next;
//	ListNode(int x) {val = x;next = null;}
//}
public class InsertionSortList {
	/**
	 *将元链表视为一堆节点，重新构造链表，构造的过程中进行插入
	 *最好时间复杂度O(n),最差时间复杂度O(n^2) 
	 */
	public ListNode insertionSortList(ListNode head)
	{
		ListNode result = new ListNode(-1);
		ListNode last = null;
		ListNode tmp = null;
		while(head != null)
		{
			last = result;
			while(last.next != null && last.next.val <= head.val)
			{
				last = last.next;
			}
			tmp = head;
			head = head.next;
			tmp.next = last.next;
			last.next = tmp;
		}
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
		ListNode result = new InsertionSortList().insertionSortList(n1);
		while(result != null)
		{
			System.out.println(result.val);
			result = result.next;
		}
	}

}
