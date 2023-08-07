//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        int n = S.length();
        int[][] t = new int[n+1][n+1];
        
        StringBuilder b = new StringBuilder(S).reverse();
        
        return LCS(S , b.toString() , n , n , t);
        
    }
    
    public int LCS(String a , String b , int m , int n , int[][] t)
    {
        for(int i = 1 ; i < m+1 ; i++)
        {
            for(int j = 1 ; j < n+1 ; j++)
            {
                if(a.charAt(i-1) == b.charAt(j-1))
                {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else 
                {
                    t[i][j] = Math.max(t[i][j-1] , t[i-1][j]);
                }
            }
        }
        
        return t[m][n];
    }
}