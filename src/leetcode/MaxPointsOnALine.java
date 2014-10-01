package leetcode;


class Point{
	int x;
	int y;
	Point()	{x = 0;y = 0;}
	Point(int a,int b)	{x = a;y = b;}
}
public class MaxPointsOnALine {
	public int getPivot(Point[] points,int s,int e)
	{
		Point tmp = points[s];
		int i = s;
		int j = e;
		while(i < j)
		{
			while(i < j && points[j].y >= tmp.y)
			{j--;}
			points[i] = points[j];
			while(i < j && points[i].y <= tmp.y)
			{i++;}
			points[j] = points[i];
		}
		points[i] = tmp;
		return i;
	}
	public void quickSort(Point[] points,int s,int e)
	{
		if(s >= e)
		{
			return;
		}
		else
		{
			int pivot = getPivot(points,s,e);
			quickSort(points,s,pivot - 1);
			quickSort(points,pivot + 1,e);
		}
	}
	public void merge(Point[] points,int s,int e,int mid)
	{
		Point[] tmpA = new Point[mid - s + 1];
		Point[] tmpB = new Point[e - mid];
		int pointerA = 0,pointerB = 0,k = s;
		for(int i = s,j = 0;i <= mid;i++,j++)
		{
			tmpA[j] = points[i];
		}
		for(int i = mid + 1,j = 0;i <= e;i++,j++)
		{
			tmpB[j] = points[i];
		}
		
		while(pointerA < tmpA.length && pointerB < tmpB.length)
		{
			if(tmpA[pointerA].x <= tmpB[pointerB].x)
			{
				points[k++] = tmpA[pointerA++];
			}
			else
			{
				points[k++] = tmpB[pointerB++];
			}
		}
		while(pointerA < tmpA.length)
		{
			points[k++] = tmpA[pointerA++];
		}
		while(pointerB < tmpB.length)
		{
			points[k++] = tmpB[pointerB++];
		}
		
	}
	public void mergeSort(Point[] points,int s,int e)
	{
		if(s < e)
		{
			int mid = (s + e) / 2;
			mergeSort(points,s,mid);
			mergeSort(points,mid + 1,e);
			merge(points,s,e,mid);
		}
	}
	
	
	public int maxPoints(Point[] points)
	{
		if(points.length <= 2)
			return points.length;
		quickSort(points,0,points.length - 1);	//根据点的y值排序，稳不稳定无所谓
		mergeSort(points,0,points.length - 1);	//根据点的x值排序，需要稳定排序
		int[] record = new int[points.length];
		record[0]++;
		int length=0;
		int li,lj;
		for(li=1,lj=0;li<points.length;li++)	
		{
			if(points[li].x == points[li-1].x && points[li].y==points[li-1].y)
			{
				record[lj]++;
			}
			else
			{
				record[++lj]++;
			}
		}
		length=lj+1;
		for(li=0,lj=1;lj<points.length;)
		{
			if(points[lj].x!=points[li].x||points[lj].y!=points[li].y)
			{
				points[++li] = points[lj++]; 
			}
			else
			{
				
				lj++;
			}
		}
		if(length <= 2)
			return points.length;
		else
		{
			int result = 2;
			int a,b,c;
			int tmp;
			for(int i = 0;i <length - 1;i++)
			{
				for(int j = i + 1;j < length;j++)
				{
					a = points[j].y - points[i].y;
					b = points[j].x - points[i].x;
					c = (points[j].y - points[i].y) * points[i].x - 
							(points[j].x - points[i].x) * points[i].y;
					tmp = 0;
					for(int p = 0;p < length;p++)
					{
						if(a * points[p].x - b * points[p].y == c)
							tmp += record[p];
					}
					if(tmp > result)
						result = tmp;
				}
			}
			return result;
		}
			
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = {new Point(0,0),new Point(1,1),new Point(1,-1)};
		System.out.println(new MaxPointsOnALine().maxPoints(points));
	}

}
