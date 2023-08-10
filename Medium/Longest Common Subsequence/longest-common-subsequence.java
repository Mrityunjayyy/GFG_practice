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
        
        lcs(s1 ,s2 , x , y , t);
        
        
        return t[x][y];
        
    }
    
    
    public static void lcs(String a , String b , int m , int n , int[][] t)
    {
        for(int i = 1 ; i < m+1 ; i++)
        {
            for(int j = 1 ; j  < n+1 ; j++)
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
    }
    
}