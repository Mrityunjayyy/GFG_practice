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
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> rotate(int N, int D)
    {
        int left = 0;
        int right = 0;
        int[] arr = new int[16];
        int d = D % 16;
        
        for(int i = 0 ; i < 16  ; i++)
        {
            arr[i] = (N & 1) == 1 ? 1 : 0;
            N = N >> 1;
        }
        
        int j = 0;
        int x = (16 - d)%16; // left starting postion;
        int y = d;
        
        while(j < 16)
        {
            if(arr[x] == 1)
            {
                left = left + (1 << j);
            }
            
            
            if(arr[y] == 1)
            {
                right = right + (1 << j);
            }
            
            
            x = (x +1 ) % 16;
            y = (y +1 ) % 16;
            j++;
        }
        
        
        ArrayList<Integer> ans = new ArrayList();
        ans.add(left);
        ans.add(right);
        
        return ans;
        
        
    }
}