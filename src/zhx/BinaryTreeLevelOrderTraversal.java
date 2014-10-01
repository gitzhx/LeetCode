package zhx;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){this.val = x;}
}
/**
 *一个队列实现树的层次遍历，变量currentLevel，nextLevel记录当前层次和下一层次节点数
 *时间复杂度O(n),空间复杂度O(n) 
 *
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		int currentLevel = 0;
		int nextLevel = 0;
		List<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer> current = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root != null)
		{
			queue.offer(root);
			currentLevel ++;
		}													//主线思想是队列实现树的层次遍历。
		while(currentLevel != 0 || nextLevel != 0)			//currentLevel记录当前层次剩余节点，nextLevel记录下一层次发现的节点
		{													
			TreeNode tmp = queue.poll();
			currentLevel --;
			current.add(new Integer(tmp.val));
			if(tmp.left != null)
			{
				queue.offer(tmp.left);
				nextLevel ++;
			}
			if(tmp.right != null)
			{
				queue.offer(tmp.right);
				nextLevel ++;
			}
			if(currentLevel == 0)
			{
				result.add(current);
				current = new ArrayList<Integer>();
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.left = n6;
		n5.right = n7;
		List<List<Integer>> result = new BinaryTreeLevelOrderTraversal().levelOrder(n1);
		for(List<Integer> lst:result)
		{
			for(Integer i:lst)
				System.out.print(i.intValue() + "   ");
			System.out.println();
		}
	}

}
