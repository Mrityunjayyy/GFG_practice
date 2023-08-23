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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0 ,1, -1 ,1, -1 ,0 ,1};
    public int  Count(int[][] matrix)
    {
        int ans = 0;
        for(int i = 0 ; i <  matrix.length ; i++)
        {
            for(int j = 0 ; j < matrix[0].length ; j++)
            {
                if(matrix[i][j] == 1)
                {
                    if(count(i , j , matrix) == true)
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    public boolean isValid(int i , int j , int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        
        if(i < 0 || i >= n || j < 0 || j >= m ) 
        return false;
        if(matrix[i][j] == 1) return false;
        
        
        
        return true;
    }
    
    public boolean count(int i , int j , int[][] matrix)
    { 
        int count= 0;
       
        for(int k = 0 ; k < 8 ; k++)
        {
           int x = i + dx[k];
           int y = j + dy[k];
           if(isValid(x , y , matrix))
           {
              count++;
           }
        }
        
        return  ( ((count &1) == 0) && count > 0)  ? true : false ; 
    }
}