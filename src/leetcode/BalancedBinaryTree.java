package leetcode;

class Result{
	boolean result = true;
}
//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) {val = x;}
//}

public class BalancedBinaryTree {
	public int figureDepth(TreeNode root,Result result)
	{
		if(root == null)
			return 0;
		else{
			int left = figureDepth(root.left,result);
			int right = figureDepth(root.right,result);
			if(left - right > 1 || left - right < -1)
				result.result = false;
			return left + 1 > right + 1?left + 1 : right + 1;
		}
	}
	
	/**
	 *判断是否为平衡二叉树必须知道每个node的深度，
	 *因此递归地主要任务是计算深度，判断是否平衡是在此基础上 
	 */
	public boolean isBalanced(TreeNode root)
	{
		Result result = new Result();
		figureDepth(root,result);
		return result.result;
	}
	public static void main(String[] args) {
	
	}

}
