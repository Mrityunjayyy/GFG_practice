//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{ 
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        
       int[][] t = new int[x+1][y+1];
        for(int[] a : t)
        {
            Arrays.fill(a , -1);
        }
        
        
        dp(x , y , s1 , s2 , t);
        return t[x][y];
    }
    
    
    
     static int dp(int x, int y, String s1, String s2 , int[][] t )
    {
        
        if(x == 0 || y == 0) return 0;
        if(t[x][y] != -1) return t[x][y];
        
        
        if(s1.charAt(x-1) == s2.charAt(y-1))
        return t[x][y] = 1 + dp(x -1 , y -1 , s1 , s2 , t);
        
        else 
        return t[x][y] = Math.max(dp(x -1 , y , s1 , s2 , t) , dp(x, y -1 , s1 , s2 , t));
    }
    
    
    
    
    
    
}