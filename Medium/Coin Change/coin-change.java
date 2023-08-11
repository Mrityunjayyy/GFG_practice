//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    static long[][] t = new long[1002][1002];
    public long count(int coins[], int N, int sum) {
         
         for(int i = 0 ; i < t.length ; i++)
         {
             t[i][0] = 1;
         }
         
         return dp(coins , sum , N);
    }
    
    public long dp(int[] coins , int sum , int n)
    {
        for(int i = 1 ; i < n+1 ; i++)
        {
            for(int j = 1 ; j < sum +1 ; j++)
            {
                if(coins[i-1] <= j)
                {
                    t[i][j] = t[i][j - coins[i-1]] + t[i-1][j];
                }
                else 
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][sum];
    }
} 