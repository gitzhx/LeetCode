package leetcode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class WordBreakII {
	/**
	 *与WordBreak是一致的，时间复杂度为O(kn) 
	 */
	public List<String> wordBreak(String s,Set<String> dict)
	{
		boolean[] result = new boolean[s.length() + 1];
		List<String> resultSentences = new ArrayList<String>();
		List<String> tmp = new ArrayList<String>();
		result[0] = true;
		for(int index = 1;index < result.length;index++)		//外层循环为字符串长度
		{
			for(String word:dict)									//内层循环为字典长度
			{
				int ws = index - word.length();				
				int we = index;
				String word1;
				if(ws >= 0)
				{
					word1 = s.substring(ws,we);							//下标比较绕，关键是子串下标ws和we
					result[index] = result[ws] && word.equals(word1);
					if(result[index])
						break;
				}
			}
		}
		getSentences(tmp,s,dict,result,result.length - 1,"");
		for(String sen:tmp)
			resultSentences.add(sen.trim());
		return resultSentences;
	}
	/**
	 * 承接WordBreak之后对结果进行规整，递归函数，时间复杂度也是O(kn)
	 * @param resultSentences
	 * @param s
	 * @param dict
	 * @param result
	 * @param location
	 * @param postfix
	 */
	public void getSentences(List<String> resultSentences,String s,Set<String> dict,boolean[] result,int location,String postfix)
	{
		if(location == 0)
		{
			resultSentences.add(postfix);
		}
		else if(location > 0)
		{
			for(String word:dict)
			{
				int ws = location - word.length();
				int we = location;
				String word1 = null;
				if(ws >= 0)
					word1 = s.substring(ws,we);
				if(word.equals(word1))
					getSentences(resultSentences,s,dict,result,location - word.length(),word + " " + postfix);
			}
		}
	}
	public static void main(String[] args) {
		List<String> result = null;
		WordBreakII wb = new WordBreakII();
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		result = wb.wordBreak(s, dict);
		for(String sentence:result)
			System.out.println(sentence);
	}

}
