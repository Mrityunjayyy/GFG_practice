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
 
    public int  Count(int[][] matrix)
    {
        int count = 0;
        for(int i = 0 ; i < matrix.length ; i++)
        {
            for(int j = 0 ; j < matrix[i].length ; j++)
            {
                if(matrix[i][j] == 1)
                {
                    if(neighbours(matrix , i , j) == true)
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public boolean neighbours(int[][] matrix , int row , int col)
    {
        int count = 0;
          for (int i = row - 1; i <= row + 1; i++) 
          {
            for (int j = col - 1; j <= col + 1; j++)
            {
                if (i >= 0 && i < matrix.length &&
                j >= 0 && j < matrix[0].length
                && (i != row || j != col)) 
                {
                    int surroundingElement = matrix[i][j];
                    if(surroundingElement == 0)
                    {
                        count++;
                    }
                }
            }
        }
        
        return ((count & 1) == 0 && count != 0) ? true : false;
        
    }
}