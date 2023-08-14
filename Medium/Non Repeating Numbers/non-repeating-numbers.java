//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int x_xor_y = 0;
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            x_xor_y = x_xor_y ^ nums[i];
        }
        
        int rsmb = x_xor_y & -x_xor_y ; //right most set bit
        int x = 0 ;
        int y = 0;
        
        for(int a : nums)
        {
            if((rsmb & a) ==0 ) //that bit for that number is zero
            {
                x = x ^ a;
            }
            else 
            {
                y = y ^ a;
            }
        }
        
        
        return (x>y) ? new int[]{y,x} : new int[]{x,y};
    }
}