package zhx;
import java.util.Queue;
import java.util.LinkedList;

/**
 *class TreeNode{
 *	int val;
 *	TreeNode left;
 *	TreeNode right;
 *	TreeNode(int x){val = x;}
 *	}
 */

public class SumRootToLeafNumbers {
	/**
	 *与MaximumDepthOfBinaryTree几乎一样，双队列进行二叉树层次遍历，只在节点出队列后的遍历操作上略有不同
	 *时间复杂度O(n) 
	 */
	public int sumNumbers(TreeNode root)
	{
		int result = 0;
		if(root == null)
			return result;
		Queue<TreeNode> queueNode = new LinkedList<>();
		Queue<Integer> queueSum = new LinkedList<>();
		queueNode.offer(root);
		queueSum.offer(root.val);
		while(!queueNode.isEmpty())
		{
			TreeNode tmpNode = queueNode.poll();
			int tmpValue = queueSum.poll();
			if(tmpNode.left == null && tmpNode.right == null)
			{
				result += tmpValue;
				continue;
			}
			if(tmpNode.left != null)
			{
				queueNode.offer(tmpNode.left);
				queueSum.offer(tmpValue * 10 + tmpNode.left.val);
			}
			if(tmpNode.right != null)
			{
				queueNode.offer(tmpNode.right);
				queueSum.offer(tmpValue * 10 + tmpNode.right.val);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		int result = new SumRootToLeafNumbers().sumNumbers(n1);
		System.out.println(result);
	}

}
