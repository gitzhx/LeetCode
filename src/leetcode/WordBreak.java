package leetcode;
import java.util.Set;
import java.util.HashSet;

public class WordBreak {
	/**
	 *动态规划:设置一个数组result[],result[i]表示从substring[1:i]可字典分解;
	 *时间复杂度为：O(kn),k=dict.size() 
	 */
	public boolean wordBreak(String s,Set<String> dict)
	{
		if(s == null || s.length() == 0 || dict.size() == 0)	//边界情况判定
			return false;
		boolean[] result = new boolean[s.length() + 1];
		result[0] = true;
		for(int index = 1;index < result.length;index++)		//外层循环为字符串长度
		{
//			System.out.println(index + ":------------");
			for(String word:dict)									//内层循环为字典长度
			{
				int ws = index - word.length();				
				int we = index;
				String word1;
				if(ws >= 0)
				{
					word1 = s.substring(ws,we);							//下标比较绕，关键是子串下标ws和we
//					System.out.println(word1+ "  " + word);
					result[index] = result[ws] && word.equals(word1);
					if(result[index])
						break;
				}
			}
		}
		return result[s.length()];
	}
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		boolean result = wb.wordBreak(s, dict);
		System.out.println(result);
	}

}
