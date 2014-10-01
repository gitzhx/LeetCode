package leetcode;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
	/**
	 *示例中原数组出现重复数，排序之后先去重(<--理解错了，比如1在原数组中出现两次组合中就可以用两次)
	 *相较于CombinationSum，该题1，原数组可能有重复值，2，组合中不能重用数组元素
	 *只在递归的游标值处不同，其他与combinationSum完全一致
	 */
	public List<List<Integer>> combinationSum2(int[] sum,int target)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tmpArray = new ArrayList<Integer>();
 		if(sum == null || sum.length == 0)						
 			return result;
 		Arrays.sort(sum);
 		dfsSearch(result,tmpArray,0,target,0,sum);
		return result;	
	}
	void dfsSearch(List<List<Integer>> result,List<Integer> tmpArray,int tmpSum,int target,int cursor,int[] candidates)
	{
		for(int i = cursor;i < candidates.length;i++)
		{
			if(i > cursor && candidates[i] == candidates[i - 1])
				continue;											//重复值的处理，很关键，查找树的同一节点的后代不能有相同值
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
				dfsSearch(result,tmpArray,tmpSum,target,i + 1,candidates);
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
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> result = new CombinationSumII().combinationSum2(candidates, target);
		for(List<Integer> tmp:result)
		{
			for(Integer i:tmp)
				System.out.print(i.toString() + " ");
			System.out.println();
		}
	}

}
