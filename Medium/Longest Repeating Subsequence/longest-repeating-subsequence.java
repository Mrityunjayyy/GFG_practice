//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int n = str.length();
        int[][] t = new int[n+1][n+1];
        
        return LCS(str , str , n , n , t);
    }
    
    public int LCS(String a , String b , int m , int n , int[][] t)
    {
        for(int i =1 ; i < m+1 ; i++)
        {
            for(int j =1 ; j < n+1 ; j++)
            {
                if(a.charAt(i-1) == b.charAt(j-1) && i != j)
                {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else 
                {
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }
        
        return t[m][n];
    }
}