package alibaba;
import java.util.Queue;
import java.util.LinkedList;

class Node{
	int val;
	Node lchild;
	Node rchild;
	Node(int val)
	{
		this.val = val;
	}
}
public class Problem3 {
	public int solution(Node root)
	{
		if(root == null)			//若树位空返回-1
			return -1;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty())
		{
			Node tmp = queue.poll();
			if(tmp.lchild != null)
				queue.offer(tmp.lchild);
			if(tmp.rchild != null)
				queue.offer(tmp.rchild);
			max = max > tmp.val ? max : tmp.val;
			min = min < tmp.val ? min : tmp.val;
		}
		return max - min;
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		Node lchild = new Node(-1);
		Node rchild = new Node(10);
		root.lchild = lchild;
		root.rchild = rchild;
		int result = new Problem3().solution(root);
		System.out.println(result);
		
	}

}
