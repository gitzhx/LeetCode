package leetcode;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BinaryTreePreorderTraversal {
	/**
	 *二叉树线序遍历的非递归实现,使用到的数据结构：栈
	 *树的线序遍历的非递归实现,时间复杂度O(n)
	 */
	public List<Integer> preorderTraversal(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode tmp = root;
		if(tmp == null)
			return result;
		while(tmp != null)
		{
			result.add(tmp.val);			//沿着左枝访问并入栈
			stack.push(tmp);
			tmp = tmp.left;
		}
		while(!stack.empty())
		{
			tmp = stack.pop().right;		//节点出栈时,处理其右孩子
			while(tmp != null)
			{
				result.add(tmp.val);
				stack.push(tmp);
				tmp = tmp.left;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node6;
		node5.right = node7;
		List<Integer> result = new BinaryTreePreorderTraversal().preorderTraversal(node1);
		for(Integer i:result)
			System.out.println(i);
	}

}
