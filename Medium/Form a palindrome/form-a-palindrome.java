//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        String b = new StringBuilder(str).reverse().toString();
        
        int m = str.length();
        int[][] t = new int[m+1][m+1];
        
        int lcs = LCS(str , b , m , m , t);
        return m - lcs;
    }
    
    
      
    public static int LCS(String a , String b , int m , int n , int[][] t)
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