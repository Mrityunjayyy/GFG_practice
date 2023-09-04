//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
      
       static char[][] fill(int n, int m, char a[][])
    {
        // first and last column
        for(int i = 0 ; i < n ; i++)
        {
            if(a[i][0] == 'O')
            dfs(a , i , 0 , 'O' , '*' , n , m);
            
            if(a[i][m-1] == 'O')
            dfs(a , i , m-1 , 'O' , '*' , n , m);
            
        }
        
        //first and last row
        for(int i = 0 ; i < m ; i++)
        {
            if(a[0][i] == 'O')
            dfs(a , 0 , i , 'O' , '*' , n , m);
            
            if(a[n-1][i] == 'O')
            dfs(a , n-1 , i , 'O' , '*' , n , m);
        }
        
        
        
        
        for(int i = 0;i < n;i++)
		{	for(int j = 0;j < m;j++)
			{
			    if(a[i][j] == 'O')
				    a[i][j] = 'X';
			}
		}
				    
				    //change - to X;
	    for(int i = 0;i < n;i++)
	    {
			for(int j = 0;j < m;j++)
			{
				if(a[i][j] == '*')
				    a[i][j] = 'O';
			}
	    }
        
        return a;
    }  
    
    public static void dfs(char[][] a , int x , int y ,char old , char now , int n , int m)
    {
        if(x >= n || x < 0 || y < 0 || y >= m)
        return;
        
        if(a[x][y] != old)
        return;
        
        a[x][y] = now;
        dfs(a, x+1, y, old, now, n, m);
        dfs(a, x-1, y, old, now, n, m);
        dfs(a, x, y+1, old, now, n, m);
        dfs(a, x, y-1, old, now, n, m);
    }

}