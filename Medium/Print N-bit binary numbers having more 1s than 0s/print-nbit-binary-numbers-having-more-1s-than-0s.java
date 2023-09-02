//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int n;
    ArrayList<String> NBitBinary(int N) {
        n = N;
        ArrayList<String> ans = new ArrayList<String>();
        solve(ans , "" , 0 , 0);
        return ans;
    }
    
    
    public void solve(ArrayList<String> ans , String s ,int zero , int one)
    {
        if(s.length() == n)
        {
            ans.add(s);
            return;
        }
        
        solve(ans , s + "1" , zero , one +1);
        if(zero < one)
        solve(ans , s + "0" , zero +1 , one);
        
    }
}