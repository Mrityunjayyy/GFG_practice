//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String S){
        String b = new StringBuilder(S).reverse().toString();
        
        int m = S.length();
        int[][] t = new int[m+1][m+1];
        
        int lcs = LCS(S , b , m , m , t);
        return m - lcs;
    }
    
    
    public int LCS(String a , String b , int m , int n , int[][] t)
    {
        for(int i =1 ; i < m+1 ; i++)
        {
            for(int j =1 ; j < n+1 ; j++)
            {
                if(a.charAt(i-1) == b.charAt(j-1))
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