package leetcode;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;

//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode right;
//	public TreeNode(int x)
//	{}
//}

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		Set<TreeNode> set = new HashSet<>();
		TreeNode tmp = root;
		while(tmp != null)				//从根节点开始,按顺序将左孩子压入栈中
		{
			stack.push(tmp);
			tmp = tmp.left;
		}
		while(!stack.isEmpty())			//依次取出栈中的每个元素
		{
			tmp = stack.pop();
			if(!set.contains(tmp))			//若该节点是第一次出栈,则重新压入并处理其右子树
			{
				set.add(tmp);
				stack.push(tmp);
				tmp = tmp.right;
				while(tmp != null)
				{
					stack.push(tmp);
					tmp = tmp.left;
				}
			}
			else							//若不是第一次出栈,即可访问
			{
				result.add(tmp.val);
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
		List<Integer> result = new BinaryTreePostorderTraversal().postorderTraversal(null);
		for(Integer i:result)
			System.out.println(i);
	}

}
