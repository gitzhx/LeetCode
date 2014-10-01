package leetcode;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

class Node{
	String word;
	int length;
	Set<String> candidates;
	Node(String word,int length,Set<String> candidates,String fatherStr)
	{
		this.word = word;
		this.length = length;
		this.candidates = new HashSet<String>();
		this.candidates.addAll(candidates);
		this.candidates.remove(fatherStr);
	}
}
class Node2{
	String word;
	int length;
	Node2(String word,int length)
	{
		this.word = word;
		this.length = length;
	}
}
public class WordLadder {
	/**
	 *广度优先搜索，(树的层次遍历)
	 *相比较于网上不超时的做法，该解法超时的原因在于Node的构造函数里地addAll，addAll在java中得实现就是遍历一遍collection，
	 *因此当出事dict非常大时，会超时，既然时间和空间复杂度都这么高。。。（虽然优雅，但是弃了）...(续：昨晚ladderLength2发现node中加candidates
	 *也不优雅，ladderLength2中在全局中去重也非常有道理，仔细想想。思想有点类似图的普里姆算法，向既优点集中按条件加点)
	 */
	public int ladderLength(String start,String end,Set<String> dict)
	{
		Queue<Node> queue = new LinkedList<>();
		dict.add(end);
		Node root = new Node(start,1,dict,start);
		queue.offer(root);
		while(!queue.isEmpty())
		{
			Node tmp = queue.poll();
			if(distance(tmp.word,end) == 0)
				return tmp.length;
			else
			{
				char[] tmpStr = tmp.word.toCharArray();
				for(int i = 0;i < tmpStr.length;i++)
				{	
					for(char c = 'a';c <= 'z';c++)
					{
						tmpStr[i] = c;
						String candiStr = new String(tmpStr);
						if(tmp.candidates.contains(candiStr))
						{
							queue.offer(new Node(candiStr,tmp.length + 1,tmp.candidates,candiStr));
						}
					}
					tmpStr[i] = tmp.word.charAt(i);
				}
			}
		}
		return 0;
	}
	
	int distance(String str1,String str2)
	{
		if(str1 == null || str2 == null || str1.length() != str2.length())
			return -1;
		else
		{
			int result = 0;
			for(int i = 0;i < str1.length();i++)
			{
				if(str1.charAt(i) != str2.charAt(i))
					result += 1;
			}
			return result;
		}
	}
	
	/**
	 *很不错的解法,(网上解法使用两个队列一个记录String，一个记录length，免去了自己解法中得开辟node，速度有小幅提升)
	 *使用两个队列：780ms		使用node：836ms
	 */
	public int ladderLength2(String start,String end,Set<String> dict)
	{
		Queue<Node2> queue = new LinkedList<>();
		Node2 root = new Node2(start,1);
		dict.add(end);
		queue.offer(root);
		while(!queue.isEmpty())
		{
			Node2 tmp = queue.poll();
			if(distance(tmp.word,end) == 0)
				return tmp.length;
			else
			{
				char[] tmpChars = tmp.word.toCharArray();
				for(int i = 0;i < tmpChars.length;i++)
				{
					for(char c = 'a';c <= 'z';c++)
					{
						tmpChars[i] = c;
						String tmpStr = new String(tmpChars);
						if(dict.contains(tmpStr))
						{
							queue.offer(new Node2(tmpStr,tmp.length + 1));
							dict.remove(tmpStr);
						}
					}
					tmpChars[i] = tmp.word.charAt(i);
				}				
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		int length = new WordLadder().ladderLength2(start, end, dict);
		System.out.println(length);
	}
}
