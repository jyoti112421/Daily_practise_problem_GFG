//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


class Solution {
    long ExtractNumber(String sentence) {
        String a[] = sentence.split(" ");
       long res = -1;
        for(int i=0;i<a.length;i++){
            String curr = a[i];
            if(Character.isDigit(curr.charAt(0))){
                if(!curr.contains("9")){
                  long num = Long.parseLong(curr);
                  res = Math.max(num, res);
                }
            }
        }
        return res;
        
    }
}