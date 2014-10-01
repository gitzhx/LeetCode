package leetcode;

public class ZigZagConversion {
	public String convert(String s,int nRows)
	{
		if(nRows == 1)
			return s;
		char[] origin = s.toCharArray();
		StringBuilder[] rowSB = new StringBuilder[nRows + 1];
		StringBuilder result = new StringBuilder("");
		for(int i = 0;i < rowSB.length;i++)
			rowSB[i] = new StringBuilder("");
		int i = 0;
		int rowNumber = 1;
		int tmp = 1;
		while(i < origin.length)
		{
			rowSB[rowNumber].append(origin[i++]);
			if(rowNumber == nRows)
				tmp = -1;
			else if(rowNumber == 1)
				tmp = 1;
			rowNumber += tmp;
		}
		for(i = 1;i <= nRows;i++)
			result.append(rowSB[i]);
		return result.toString();
	}
	public static void main(String[] args) {
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
	}

}
