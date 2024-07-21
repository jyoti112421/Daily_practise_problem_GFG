//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        long pos = 0;
        long neg = 0;
        long mod = (long)(1e9+7);
        long largestNeg = Integer.MIN_VALUE;
        int negCount = 0;
        for(int i=0;i<arr.size();i++){
            int num = arr.get(i);
            if(num>0){
                if(pos==0)
                    pos = num % mod;
                else
                    pos = (pos * num) % mod;
            }
            else if(num<0){
                if(neg==0)
                    neg = num%mod;
                else
                    neg = (neg * num) % mod;
                largestNeg = Math.max(largestNeg,num);
                negCount++;
            }
        }
        long res=0;
        if(negCount<2)
            neg = 0;
        else if(neg<0)
            neg /= largestNeg;
            
        if(pos!=0)
            res = pos;
        if(res==0)
            res = neg;
        else if(neg!=0)
            res = (res*neg)%mod;
        
        return res%mod;
    }
}