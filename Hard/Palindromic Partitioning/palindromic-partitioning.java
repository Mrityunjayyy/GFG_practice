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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] t = new int[501][501];
    static boolean[][] palindrome = new boolean[501][501];
    static int palindromicPartition(String str)
    {
        for(int[] a : t)
        {
            Arrays.fill(a , -1);
        }
        
        return solve(str , 0 , str.length() -1);
    }
    
    
    public static int solve(String s , int i , int j)
    {
        if(t[i][j] != -1) 
        return t[i][j];
        
        if(i >= j || isPalindrome(s , i, j))
        {
            t[i][j] = 0;
            return 0;
        } 
        
           
        int min = Integer.MAX_VALUE;
        
        for(int k = i ; k <= j-1 ; k++)
        {
            // int left;
            // if(t[i][k] != -1)
            // {
            //   left = t[i][k];   
            // }
            // else 
            // {
            //     left = solve(s , i , k);
            //     t[i][k] = left;
            // }
            
            int right;
            if(t[k+1][j] != -1)
            {
                right = t[k+1][j];
            }
            else 
            {
                right = solve(s , k+1 , j);
                t[k+1][j] = right;
            }
            
            if(isPalindrome(s , i , k) == true)
            {
            int temp_ans =  1 + right;
           
            if(temp_ans < min)
            {
                min = temp_ans;
            }
            }
        }
        
        return t[i][j] = min ;
    }
    
   
    
    static boolean isPalindrome(String s , int i  , int j)
    {
        if(i < 0 || j >= s.length()) return false;
        
        if(i == j) return true;
        
        if(palindrome[i][j] == true)  return true;
        
        
    
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            
            i++;
            j--;
        }
        
        return palindrome[i][j] = true;
    }
}