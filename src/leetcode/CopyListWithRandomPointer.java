package leetcode;
import java.util.HashMap;
import java.util.Map;

class RandomListNode{
	int label;
	RandomListNode next,random;
	RandomListNode(int x) {this.label = x;}
}
public class CopyListWithRandomPointer {
	/**
	 *用一个HashMap记录新旧表节点的对应关系，第二次遍历的时候处理random字段，
	 *时间复杂度:O(n) 
	 */
	public RandomListNode copyRandomList(RandomListNode head)
	{
		Map<RandomListNode,RandomListNode> map= new HashMap<>();
		RandomListNode result = new RandomListNode(-1);
		RandomListNode tmp = result;
		RandomListNode tmp2 = head;
		while(tmp2 != null)
		{
			tmp.next = new RandomListNode(tmp2.label);
			tmp = tmp.next;
			tmp.next = null;
			map.put(tmp2,tmp);
			tmp2 = tmp2.next;
		}
		tmp = result.next;
		tmp2 = head;
		while(tmp != null && tmp2 != null)
		{
			tmp.random = map.get(tmp2.random);
			tmp = tmp.next;
			tmp2 = tmp2.next;
		}
		return result.next;
	}
	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		CopyListWithRandomPointer cl = new CopyListWithRandomPointer();
		RandomListNode result = cl.copyRandomList(n1);
		while(result != null)
		{
			System.out.println(result.label);
			result = result.next;
		}
	}

}
