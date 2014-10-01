package leetcode;

public class GasStation {
	/**
	 *适当的剪枝，时间复杂度为O(n)
	 */
	public int canCompleteCircuitV1(int[] gas,int[] cost)
	{
		if(gas == null || gas.length == 0)			//边界情况的特殊处理,若所给数据为空，或只有一个加油站
			return -1;
		if(gas.length == 1 && gas[0] >= cost[0])
			return 0;
		else if(gas.length == 1 && gas[0] < cost[0])
			return -1;
		
		int N = gas.length;
		int tank = 0;
		int here;
		int go;
		int index = -1;
		for(int start = 0;start < N;)			//start表示所选择的起点，顺时针计算
		{
			tank = 0;
			here = start;
			go = (here + 1) % N;
			do{										//首先在所在位置加油，再减去到下个加油站的消耗，
				tank += gas[here];					//然后将here、go依次下移一个位置
				tank -= cost[here];					//判断条件为假设到达时的tank油量 && 到达站不为start站
				here = go;
				go = (go + 1) % N;
			}
			while(tank >= 0 && here != start);
			if(tank >= 0 && here == start)					//依据循环条件，分别处理跳出循环的三种情况
				return start;								//1,tank >= 0 && here == start 说明正确走完一圈
			else if(tank < 0 && here > start && here < N)	//2,tank < 0 && here != start
			{											
				start = here;
			}
			else											//3,tank < 0 && here == start 说明没有可行方案
				break;										//(注意2里有可能在index_0~index_start之间，这也说明没有可行方案
		}													//因此可以与3合并)改遍之后的判断条件如代码所示
		return index;
	}
	
	public static void main(String[] args) {
		int[] gas = new int[]{1,2};
		int[] cost = new int[]{2,1};
		int result = new GasStation().canCompleteCircuitV1(gas, cost);
		System.out.println(result);
	}

}
