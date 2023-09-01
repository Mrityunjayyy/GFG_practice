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
            int N = Integer.parseInt(in.readLine().trim());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.pattern(N);
            for(int i = 0;i < ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> pattern(int N){
        List<Integer> ans = new ArrayList<Integer>();
        solve(ans , N , N , true);
        return ans;
    }
    
    public static void solve(List<Integer> ans , int N , int curr , boolean flag)
    {  
        
        ans.add(curr);
        
        if(curr == N && flag == false)
        {
            return;
        }
        
    
        if(flag == true) // decreading order
        {
            if(curr - 5 > 0) // increasing order will start after this
            solve(ans , N , curr - 5 , true);
            else 
            solve(ans , N , curr - 5 , false);
        }
        else  // increasing order
        {
            solve(ans , N , curr  + 5 , false);
        }
         
    }
    
    
    
}