//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int N;
    public List<String> AllParenthesis(int n) 
    {
        N = n;
        List<String> ans = new ArrayList();
        solve(ans , "" , 0 , 0);
        
        return ans;
    }
    
    public void solve(List<String> ans , String s , int oc , int cc)
    {
        if(s.length() == 2*N)
        {
            ans.add(s);
            return;
        }
        
        if(oc < N)
        solve(ans , s + "(" , oc +1 , cc);
        
        if(oc > cc)
        solve(ans , s + ")" , oc , cc+1);
    }
}