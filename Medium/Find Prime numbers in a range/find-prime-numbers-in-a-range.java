//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.primeRange(M, N);
            for (int i : ans) System.out.print(i + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> primeRange(int M, int N) {
       boolean[] prime = new boolean[N+1];
       Arrays.fill(prime , true);
       prime[0] = false;
       prime[1] = false;
       
       sieveOfEratosthenes(prime , N);
       
       ArrayList<Integer> ans = new ArrayList<>();
       for(int i = M ; i <= N ; i++)
       {
           if(prime[i] == true)
           ans.add(i);
       }
       
       return ans;
       
    }
    
    
    public void sieveOfEratosthenes(boolean[] prime , int N)
    {
        for(int i = 2 ; i*i <= N ; i++)
        {
            for(int j = 2 * i ; j <= N ; j = j + i)
            {
                prime[j] = false;
            }
        }
    }
}