package zhx;
import java.util.List;
import java.util.ArrayList;

public class LetterCombinationOfAPhoneNumber {
	/**
	 *该题逻辑类似combinations，同理的while循环
	 *keys[][]用来记录对应按钮上的字母如:keys[2] : {'a','b','c'}
	 *numbers[]用来存储digits中拆解下来的数字
	 *cursor[] 与numbers等长，用来记录各数字的对应的字符数组游标
	 */
	public List<String> letterCombinations(String digits)
	{
		List<String> result = new ArrayList<String>();
		if(digits == null || digits.length() == 0)
		{
			result.add("");							//这句是题目的要求。。
			return result;
		}
		char[] number2 = new String("abc").toCharArray();
		char[] number3 = new String("def").toCharArray();
		char[] number4 = new String("ghi").toCharArray();
		char[] number5 = new String("jkl").toCharArray();
		char[] number6 = new String("mno").toCharArray();
		char[] number7 = new String("pqrs").toCharArray();
		char[] number8 = new String("tuv").toCharArray();
		char[] number9 = new String("wxyz").toCharArray();
		char[][] keys = {null,null,number2,number3,number4,number5,number6,number7,number8,number9};
		char[] tmp = digits.toCharArray();
		int[] numbers = new int[tmp.length];
		int[] cursor = new int[numbers.length];
		for(int i = 0;i < tmp.length;i++)
		{
			numbers[i] = Integer.decode(new Character(tmp[i]).toString());
		}
		int last = cursor.length - 1;
		int border = keys[numbers[last]].length - 1;
		while(cursor[0] < keys[numbers[0]].length)		//while循环开始，循环条件是cursor[0]还在keys[numbers[0]]长度范围内
		{
			StringBuilder tmpStr = new StringBuilder();
			for(int i = 0;i < cursor.length;i++)			//1:组合出字符串，add进result中
			{
				tmpStr.append(keys[numbers[i]][cursor[i]]);
			}
			result.add(tmpStr.toString());
			if(cursor[last] < border)						//2:判断cursor[last]是否到了keys[numbers[last]]边界
				cursor[last] += 1;								//没到，cursor[last]++即可
			else												//已到，从后向前改变cursor
			{
				int pre = last - 1;
				while(pre >= 0 && cursor[pre] == keys[numbers[pre]].length - 1)
					pre --;
				if(pre < 0)
					break;
				else
				{
					cursor[pre] += 1;
					for(int i = pre + 1;i < cursor.length;i++)
						cursor[i] = 0;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		List<String> result = new LetterCombinationOfAPhoneNumber().letterCombinations("2");
		for(String str:result)
		{
			System.out.println(str);
		}
	}

}
