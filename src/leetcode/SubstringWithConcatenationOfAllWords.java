package leetcode;
import java.util.List;
import java.util.ArrayList;


public class SubstringWithConcatenationOfAllWords {
	/**
	 *简单粗暴，时间复杂度O(s.length x L.length),超时,没考虑L中可重复的情况,错误！ 
	 */
	public List<Integer> findSubstringV1(String s,String[] L)
	{
		List<Integer> result = new ArrayList<>();
		int length = 0;
		int location;
		boolean flag;
		for(String tmp:L)
			length += tmp.length();
		for(int i = 0;i < s.length() - length;i++)
		{
			flag = true;
			StringBuilder sub = new StringBuilder(s.substring(i,i + length));
			for(String tmp:L)
			{
				location = sub.indexOf(tmp);
				if(location == -1)
				{
					flag = false;
					break;
				}
				else
					sub.delete(location,location + tmp.length());
			}
			if(flag == true)
				result.add(i);
		}
		return result;
	}
	
	public List<Integer> findSubstringV2(String s,String[] L)
	{
		List<Integer> result = new ArrayList<>();
		if(s == null || s.length() == 0 || L == null)
			return result;
		
		
//		for(int i = 0;i < wLen;i++)						//i取值从0到wLen-1,表示所查找串起始于哪一mod值
//		{
//			record.clear();								//record类型为:HashMap<String,queue<Integer>>
//			start = i;
//			total = 0;
//			for(int j = i;j <= sLen - wlen;j += wLen)	//j以单词长度为步长
//			{
//				word = s.substring(j, j + wLen - 1);
//				if(record.containsKey(word))				//若指针所在单词在L中......
//				{
//																	//1,若可添加
//					if(total < ruleCount && record.get(word).size() < rule.get(word))						//1,此时若已是完整子串
//					{
//						total++;
//						record.get(word).offer(j);
//					}
//					else											//2,若不可添加
//					{
//						if(total == ruleCount)
//							result.add(start);
//						
//						start = record.get(word).poll() + wLen;			//重新复制start为上次word出现之后
//						//TODO:遍历record字典,清除所有key对应的value中在start之前的索引,并操作total
//					}
//				}
//				else										//若指针所在单词不在L中
//				{
//					//TODO:清空record中所有key对应的value队列,归零total
//					start = j + wLen;
//				}
//			}
//			
//		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		String s = "barfoothefoobarman/";
		String[] L = new String[]{"foo", "bar"};
		List<Integer> l = new SubstringWithConcatenationOfAllWords().findSubstringV1(s,L);
		for(Integer i:l)
		{
			System.out.println(i);
		}
	}

}
