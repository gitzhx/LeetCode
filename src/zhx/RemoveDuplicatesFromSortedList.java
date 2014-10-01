package zhx;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;next = null;}
}
public class RemoveDuplicatesFromSortedList {
	/**
	 *没有难度，链表的遍历和删除操作
	 *时间复杂度O(n) 
	 */
	public ListNode deleteDuplicates(ListNode head)
	{
		if(head == null)
			return head;
		ListNode last = head;
		ListNode tmp = head.next;
		int preValue = last.val;
		while(tmp != null)
		{
			if(tmp.val != preValue)
			{
				last = tmp;
				tmp = last.next;
				preValue = last.val;
			}
			else
			{
				tmp = tmp.next;
				last.next = tmp;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		ListNode result = new RemoveDuplicatesFromSortedList().deleteDuplicates(n1);
		while(result != null)
		{
			System.out.println(result.val);
			result = result.next;
		}
	}

}
