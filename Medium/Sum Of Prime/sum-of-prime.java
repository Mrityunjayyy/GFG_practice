//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int[] ptr = ob.getPrimes(N);

            System.out.println(ptr[0] + " " + ptr[1]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] getPrimes(int N) {
        boolean[] prime = new boolean[N+1];
        Arrays.fill(prime , true);
        prime[0] = false;
        prime[1] = false;
        
        sieveOfEratosthenes(prime , N);
        
        
        
        int i = 0 , j = prime.length -1;
        
        while(i < j)
        {   
            if(prime[i] == false) i++;
            if(prime[j] == false) j--;
            
            if(prime[i] && prime[j])
            {
                if(i + j == N)
                {
                    return new int[]{i ,j};
                }
                
                else if(i + j < N)
                i++;
                
                else 
                j--;
                
            }
        }
        
        
        return new int[]{-1,-1};
        
        
        
    }
    
    
    static void sieveOfEratosthenes(boolean[] prime , int N)
    {
        for(int i = 2 ; i*i <= N ; i++)
        {
            for(int j = 2*i ; j <= N ; j = j + i)
            {
                prime[j] = false;
            }
        }
    }
};