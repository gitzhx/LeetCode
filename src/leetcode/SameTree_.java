package leetcode;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val)
	{
		this.val = val;
	}
}
public class SameTree_ {
	public boolean isSameTree(TreeNode p,TreeNode q)
	{
		if(p == null && q == null)
		{return true;}
		else if(p == null && q != null)
		{return false;}
		else if(p != null && q == null)
		{return false;}
		else
		{
			return (p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
		}
	}
}