package leetcode;
import java.util.LinkedList;
import java.util.Queue;
//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x)
//	{
//		val = x;
//	}
//}
public class MaximumDepthOfBinaryTree {
	/**
	 *关于树的深度，两个队列，一个层次遍历的节点队列，一个节点深度队列，是比较高效的做法，非递归，时间复杂度O(n) 
	 */
	public int maxDepth(TreeNode root)
	{
		int result = 0;
		if(root == null)
			return result;
		Queue<TreeNode> queueNode = new LinkedList<>();		//二叉树的遍历队列
		Queue<Integer> queueDepth = new LinkedList<>();		//对应节点队列的深度队列
		queueNode.offer(root);
		queueDepth.offer(1);
		while(!queueNode.isEmpty())							//二叉树的层次遍历
		{
			TreeNode tmpNode = queueNode.poll();
			int tmpDepth = queueDepth.poll();
			result = tmpDepth;
			if(tmpNode.left != null)
			{
				queueNode.offer(tmpNode.left);
				queueDepth.offer(tmpDepth + 1);
			}
			if(tmpNode.right != null)
			{
				queueNode.offer(tmpNode.right);
				queueDepth.offer(tmpDepth + 1);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(0);
		TreeNode n4 = new TreeNode(0);
		TreeNode n5 = new TreeNode(0);
		TreeNode n6 = new TreeNode(0);
		n1.left = n2;
		n2.left = n3;
		n3.left = n4;
		n4.right = n5;
		n5.left = n6;
		int result = new MaximumDepthOfBinaryTree().maxDepth(n1);
		System.out.println(result);
	}

}
