package zhx;
import java.util.Queue;
import java.util.LinkedList;

/**
 *TreeNode{
 *	int val;
 *	TreeNode left;
 *	TreeNode right;
 *	TreeNode(int x){val = x;}
 *} 
 */

public class MinimumDepthOfBinaryTree {
	/**
	 *与树的层次有关，老手段，双队列+层次遍历
	 *时间复杂度O(n) 
	 */
	public int minDepth(TreeNode root)
	{
		int result = 0;
		if(root == null)
			return result;
		result = Integer.MAX_VALUE;
		Queue<TreeNode> queueNode = new LinkedList<>();
		Queue<Integer> queueDepth = new LinkedList<>();
		queueNode.offer(root);
		queueDepth.offer(1);
		while(!queueNode.isEmpty())
		{
			TreeNode node = queueNode.poll();
			int depth = queueDepth.poll();
			if(node.left == null && node.right == null)
			{
				result = result < depth ? result : depth;
				continue;
			}
			if(node.left != null)
			{
				queueNode.offer(node.left);
				queueDepth.offer(depth + 1);
			}
			if(node.right != null)
			{
				queueNode.offer(node.right);
				queueDepth.offer(depth + 1);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		int result = new MinimumDepthOfBinaryTree().minDepth(n1);
		System.out.println(result);
	}

}
