package zhx;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

/**
 *class TreeNode{
 *int val;
 *TreeNode left;
 *TreeNode right;
 *TreeNode(int x) {this.val = x;}
 *} 
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	/**
	 *与BinaryTreeLevelOrderTraversal和~II基本无区别，主体是层次遍历
	 *差别在用一个变量level记录已经遍历到的层次，奇数层和偶数层层次list插入元素时有区别
	 *时间复杂度O(n),空间复杂度O(n) 
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root)
	{
		int level = 0;
		int currentLevel = 0;
		int nextLevel = 0;
		List<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer> current = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root != null)
		{
			queue.offer(root);
			currentLevel ++;
		}													
		while(currentLevel != 0 || nextLevel != 0)			
		{													
			TreeNode tmp = queue.poll();
			currentLevel --;
			if(level % 2 == 0)								//与BinaryTreeZigzagOrderTraversal和~II的区别
				current.add(new Integer(tmp.val));
			else
				current.add(0,new Integer(tmp.val));
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
				level++;
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
		List<List<Integer>> result = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(n1);
		for(List<Integer> lst:result)
		{
			for(Integer i:lst)
				System.out.print(i.intValue() + "   ");
			System.out.println();
		}
	}

}
