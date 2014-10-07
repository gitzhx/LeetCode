package leetcode;

//class ListNode{
//	int val;
//	ListNode next;
//	public ListNode(int x)
//	{
//		this.val = x;
//		next = null;
//	}
//}

public class AddTwoNumbers_ {
	public ListNode addTwoNumbers(ListNode l1,ListNode l2)
	{
		ListNode result = new ListNode(-1);
		ListNode last = result;
		int carry = 0;
		int tmp = 0;
		while(l1 != null || l2 != null)
		{
			if(l1 == null)
			{
				tmp = l2.val + carry;
				l2 = l2.next;
			}
			else if(l2 == null)
			{
				tmp = l1.val + carry;
				l1 = l1.next;
			}
			else
			{
				tmp = l1.val + l2.val + carry;
				l1 = l1.next;
				l2 = l2.next;
			}
			last.next = new ListNode(tmp % 10);
			last = last.next;
			carry = tmp / 10;
		}
		if(carry != 0)
			last.next = new ListNode(carry);
		return result.next;
	}
	public static void main(String[] args) {
		ListNode n11 = new ListNode(3);
		ListNode n12 = new ListNode(4);
		ListNode n13 = new ListNode(2);
		ListNode n21 = new ListNode(4);
		ListNode n22 = new ListNode(6);
		ListNode n23 = new ListNode(5);
		n11.next = n12;
		n12.next = n13;
		n21.next = n22;
		n22.next = n23;
		ListNode result = new AddTwoNumbers_().addTwoNumbers(n11, n21);
		while(result != null)
		{
			System.out.println(result.val);
			result = result.next;
		}
	}

}
