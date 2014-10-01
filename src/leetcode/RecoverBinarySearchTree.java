package leetcode;
import java.util.ArrayList;

//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
//}
class Some{
	TreeNode pre = null;
	TreeNode next = null;
}

public class RecoverBinarySearchTree {
	/**
	 *以中序遍历为基础，找出异常相邻点对，(第一次异常的pre是异常点，第二次异常的next是异常点，还需注意若交换的是原相邻的两点则只会有一次异常)
	 */
	public void recoverTree(TreeNode root)
	{
		Some tmp = new Some();
		ArrayList<TreeNode> list = new ArrayList<>(2);
		LDR(root,tmp,list);
		if(list.size() != 0)
		{
			int a = list.get(0).val;
			list.get(0).val = list.get(1).val;
			list.get(1).val = a;
		}
	}
	private void LDR(TreeNode root,Some tmp,ArrayList<TreeNode> list)
	{
		if(root != null)
		{
			LDR(root.left,tmp,list);
			tmp.pre = tmp.next;
			tmp.next = root;
			if (tmp.pre != null) 
			{
				if (tmp.pre.val > tmp.next.val) 
				{
					if (list.size() == 0)
					{
						list.add(tmp.pre);
						list.add(tmp.next);
					}
					else
					{
						list.remove(list.size() - 1);
						list.add(tmp.next);
					}
				}
			}
			LDR(root.right,tmp,list);
		}
			
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(0);
		root.right = right;
		new RecoverBinarySearchTree().recoverTree(root);
		
		
	}

}
