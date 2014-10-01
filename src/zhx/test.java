package zhx;
import java.util.ArrayList;
import java.util.Arrays;

public class test {  
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {  
        // IMPORTANT: Please reset any member data you declared, as  
        // the same Solution instance will be reused for each test case.  
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
        if(candidates.length == 0)  
            return res;  
        Arrays.sort(candidates);  
        ArrayList<Integer> sum = new ArrayList<Integer>();  
        dfs(res, candidates, target, sum, 0, 0);  
        return res;  
    }  
    public void dfs(ArrayList<ArrayList<Integer>> res, int[] array, int target, ArrayList<Integer> sum, int step, int tmpsum)  
    {  
        if(tmpsum == target)  
        {  
            if(!res.contains(sum))  
                res.add(new ArrayList<Integer>(sum));  
            return;  
        }  
        if(tmpsum > target)  
            return;  
        for(int i = step; i < array.length; i++)  
        {  
            sum.add(array[i]);  
            dfs(res, array, target, sum, i, tmpsum + array[i]);  
            sum.remove(sum.size() - 1);  
        }  
        return;  
    }  
}