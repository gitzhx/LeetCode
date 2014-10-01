package leetcode;

//class ListNode{
//	int val;
//	ListNode next;
//	ListNode(int x)
//	{
//		val = x;
//		next = null;
//	}
//}

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head,int m,int n)
	{
		if(m > n)
			throw new NullPointerException();
		if(m == n)
			return head;
		else{
			ListNode origin = new ListNode(-1);
			ListNode origin_2 = new ListNode(-1);
			ListNode tail = null;
			ListNode tmp = null;
			origin.next = head;
			ListNode p = origin;
			int i ;
			for(i = 1;i < m;i++)
				p = p.next;
			
			tail = p.next;
			p.next = tail.next;
			origin_2.next = tail;
			i++;
			for(;i <= n;i++)
			{
				tmp = p.next;
				p.next = tmp.next;
				tmp.next = origin_2.next;
				origin_2.next = tmp;
			}
			tail.next = p.next;
			p.next = origin_2.next;
			return origin.next;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode p = head;
		for(int i = 2;i <= 5;i++)
		{
			p.next = new ListNode(i);
			p = p.next;
		}
		head = new ReverseLinkedListII().reverseBetween(head, 1, 3);
		for(p = head;p != null;p = p.next)
			System.out.println(p.val);
	}

}
