//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


class Solution 
{
    void solve(int ind, int arr[], int n, int k, List<List<Integer>> res, List<Integer> ds)
    {
        if(k == 0) 
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        if(ind < n && arr[ind] <= k) 
        {
            for(int i = ind; i < n; i++) 
            {
                if(i > ind && arr[i] == arr[i - 1])
                    continue;
                    
                ds.add(arr[i]);
                solve(i + 1, arr, n, k - arr[i], res, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) 
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        
        Arrays.sort(arr);
        solve(0, arr, n, k, res, ds);
        
        return res;
    }
}