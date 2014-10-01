package leetcode;
import java.util.ArrayList;
public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n)
	{
		ArrayList<String> result = new ArrayList<String>();
		generate(result,"",0,0,n);
		return result;
	}
	public void generate(ArrayList<String> result,String tmp,int ln,int rn,int n)
	{
		if(ln == n)
		{
			for(int i = rn + 1;i <= n;i++)
			{
				tmp = tmp + ")";
			}
			//System.out.println(tmp);
			result.add(tmp);
			return;
		}
		else{
			generate(result,tmp +"(",ln + 1,rn,n);
			if(ln > rn)
				generate(result,tmp + ")",ln,rn + 1,n);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> result = new GenerateParentheses().generateParenthesis(1);
		System.out.println(result.size());
	}

}
