//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.primeProduct(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long primeProduct(int N) 
    { 
      long ans = 1l;
      
      for(int i = 2 ;  i <= N ; i++)
      {
          if(N % i == 0)
          {
              ans = ans * i;
              
              while(N % i == 0)
              {
                  N /= i;
              }
          }
      }
      
      return ans;
      
    }
    
   
}