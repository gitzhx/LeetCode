package leetcode;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
	/**
	 * 分支限界，采用深度优先的搜索策略
	 * 递归寻找数的组合
	 */
	public List<List<Integer>> combinationSum(int[] candidates,int target)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tmpArray = new ArrayList<Integer>();
 		if(candidates == null || candidates.length == 0)
 			return result;
 		Arrays.sort(candidates);
 		dfsSearch(result,tmpArray,0,target,0,candidates);
		return result;	
	}
	void dfsSearch(List<List<Integer>> result,List<Integer> tmpArray,int tmpSum,int target,int cursor,int[] candidates)
	{
		for(int i = cursor;i < candidates.length;i++)
		{
			tmpSum += candidates[i];
			if(tmpSum == target)
			{
				tmpArray.add(new Integer(candidates[i]));
				result.add(new ArrayList<Integer>(tmpArray));
				tmpArray.remove(tmpArray.size() - 1);
			}
			else if(tmpSum < target)
			{
				tmpArray.add(new Integer(candidates[i]));
				dfsSearch(result,tmpArray,tmpSum,target,i,candidates);
				tmpArray.remove(tmpArray.size() - 1);
			}
			else		//减枝
			{
				return;
			}
			tmpSum -= candidates[i];		//别忘了，减去这次加上的值
		}
	}
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> result = new CombinationSum().combinationSum(candidates, target);
		for(List<Integer> tmp:result)
			for(Integer i:tmp)
				System.out.println(i);
	}

}





