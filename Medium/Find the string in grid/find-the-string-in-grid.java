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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{ 
      static private char[][] matrix;
      static private String a;
      int[] dx = {-1, -1 , -1 ,0, 0, 1, 1, 1};
      int[] dy = {-1, 0,  1,  -1,  1,  -1, 0, 1};
      
    public int[][] searchWord(char[][] grid, String word)
    {
      
        matrix = grid;
        a = word;
        
        int n = grid.length;
        int m = grid[0].length;
        
        ArrayList<int[]> ans = new ArrayList();
        
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                for(int k = 0 ; k < 8 ; k++)
                {
                    if(isValid(i , j , 0) 
                    && helper( i , j , k , 0) )
                    {
                        ans.add(new int[]{i,j});
                        break;
                    }
                }
            }
        }
        
        Collections.sort(ans , (a,b) -> a[0] - b[0]);
        
        int rows = ans.size();
        int[][] temp = new int[rows][];
        
        for(int i = 0 ; i < rows ; i ++)
        {
            temp[i] = ans.get(i);
        }
        
        return temp;
    }
    
    public boolean helper(int x , int y , int direction ,int index)
    {
        
        if(index == a.length()-1)
        return true;
        
        if(isValid(x + dx[direction] , y + dy[direction] , index + 1 ))
        {
            return helper(x + dx[direction] , y + dy[direction] 
            , direction ,index +1 );
        }
        
        
        return false;
        
    }
    
    
    
    public boolean isValid(int i , int j ,  int index)
    {
        if(index >= a.length()) return false;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        
        if(i < 0  || i >= n || j < 0 || j >= m) return false;
        
        return matrix[i][j] == a.charAt(index);
    }
}