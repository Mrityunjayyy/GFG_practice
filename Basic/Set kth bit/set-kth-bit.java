//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N = sc.nextInt();
            int K = sc.nextInt();
           
            Solution ob = new Solution();
            int ans = ob.setKthBit(N,K);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int setKthBit(int N,int K){
        
        // int count = (int)Math.floor( Math.log(N) / Math.log(2) )  + 1;
        
        // if(count-K < 0) return N;
        
        int num = 1 << K ;
       // System.out.println(num);
        
        return N | num ;
    }
}