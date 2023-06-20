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
    
    public List<String> AllParenthesis(int n) 
    {
        ArrayList<String> al = new ArrayList<String>();
        
        pp(al , n , 0 , 0 , "");
        
        return al;
    }
    
    
    public void pp(ArrayList<String> al ,int n , int oc , int cc , String ans)
    {
        
        if(oc == n && cc == n)
        {
            al.add(ans);
            return;
        }
        
        if(oc < n)
        {
            pp(al , n , oc +1 , cc , ans + "(");
        }
        
        if(oc > cc)
        { 
            pp(al , n , oc , cc +1  , ans + ")");
        }
    }
}