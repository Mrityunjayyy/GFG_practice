//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minDeletions(String str, int n)
    {
        StringBuilder sb = new StringBuilder(str).reverse();
        
        int[][] t = new int[n+1][n+1];
        
        int lcs = LCS(str , sb.toString() , n , n , t);
        
        return n - lcs; // str.length() - lcs.length
    }
    
    public int LCS(String a , String b , int m , int n , int[][] t )
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