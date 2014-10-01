package leetcode;
import java.util.ArrayList;
//class ListNode{
//	int val;
//	ListNode next;
//	ListNode(int x)
//	{
//		this.val = x;
//		next = null;
//	}
//}

public class SwapNodesInPairs {
	/**
	 *设置两个指针pre,next遍历每一步处理两个节点,按next、pre顺序进队列，最后遍历一遍队列生成新的链表
	 *时间复杂度O(n) 
	 */
	public ListNode swapPairs(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		else
		{
			ArrayList<ListNode> list = new ArrayList<>();
			ListNode pre = head;
			ListNode next = head.next;
			ListNode result = new ListNode(-1);
			ListNode last = result;
			while(pre != null && next != null)
			{
				list.add(next);
				list.add(pre);
				pre = next.next;
				if(pre != null)
					next = pre.next;
				else
					next = null;
			}
			if(pre != null)
				list.add(pre);
			for(ListNode n:list)
			{
				last.next = n;
				last = last.next;
			}
			last.next = null;
			return result.next;
		}
	}
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode result = new SwapNodesInPairs().swapPairs(n1);
		while(result != null)
		{
			System.out.println(result.val);
			result = result.next;
		}
	}

}
