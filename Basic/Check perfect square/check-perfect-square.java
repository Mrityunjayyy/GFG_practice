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
            System.out.println(ob.checkPerfectSquare(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int checkPerfectSquare(int N){
     int yes = 0;
     int low = 0 , high = N ;
     
     while(low <= high)
     {
         int mid = low + (high - low)/2;
         long result = mid * mid;
         
         if(result == N)
         { 
             yes =1; 
             break;
         }
         
         else if(result < N)
         { 
             low = mid +1 ;
         }
         
         else 
         { high = mid -1 ;}
     }
     
     return yes;
    }
}