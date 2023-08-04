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
    public long count(int coins[], int N, int sum) {
        
        return subSets(coins , sum , N);
    }
    
    public long subSets(int[] coins , int sum , int n)
    {
        long[] t = new long[sum+1];
        
        t[0] = 1L;
        
          for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                t[j] += t[j - coins[i]];
            }
        }
        
        return t[sum];
    }
}