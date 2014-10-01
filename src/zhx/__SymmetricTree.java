package zhx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *TreeNode{
 *int val;
 *TreeNode left;
 *TreeNode right;
 *TreeNode()
 *}
 */
public class __SymmetricTree {
	public boolean isSymmetricRecursively(TreeNode root)
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
	
		return true;
	}
	public static void main(String[] args) {
		
	}

}
