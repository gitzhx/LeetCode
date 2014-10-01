package leetcode;
import java.util.Map;
import java.util.HashMap;
class Page{
	int key;
	Page next;
	public Page(int x)
	{
		this.key = x;
		this.next = null;
	}
}
public class _LRUCache {
	Map<Integer,Integer> map;
	int limit;
	Page head;
	Page tail;
	public void LRUCache(int capacity)
	{	
		limit = capacity;
		map = new HashMap<>();
		tail = new Page(-1);
		head = tail;
	}
	public int get(int key)
	{
		Integer result = map.get(key);
		if(result == null)
			return -1;
		else
			return result.intValue();
	}
	public void set(int key,int value)
	{
		if(map.containsKey(key))
		{
			map.put(key, value);
			Page tmp = tail;
			while(tmp.next.key != key)
				tmp = tmp.next;
//			head
		}
		else if(!map.containsKey(key) && map.size() < limit)
		{
			//TODO	直接分配新页面，并处理链表
		}
		else
		{
			//TODO	找出需要替换的页面，处理链表
		}
	}
	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<>();
		map.put(new Integer(1000),new Integer(2));
		Integer result = map.get(1000);
		if(result == null)
			System.out.println("null");
		else
			System.out.println(result);
	}

}
