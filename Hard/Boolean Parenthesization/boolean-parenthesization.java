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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
  // static HashMap<String , Integer> map = new HashMap<>();
    static int[][][] t = new int[201][201][2];
    static int mod = 1003;
    static int countWays(int N, String S){
        
        for(int i = 0 ; i < t.length ; i++)
        {
            for(int j = 0 ; j <  t[0].length ; j++)
            {
                for(int k = 0 ; k < 2 ; k++)
                {
                    t[i][j][k] = -1;
                }
            }
        }
        
        return solve(S.toCharArray() , 0 , N-1 , true);
    }
    
    
    static int solve(char[] s , int i , int j , boolean isTrue)
    {
        if(i > j) return 0;
        
        if(i == j)
        {
            if(isTrue == true)
            return s[i] == 'T' ? 1 : 0;
            else 
            return s[i] == 'F' ? 1 : 0;
        }
        
        int z = isTrue ? 1 : 0;
        
        if(t[i][j][z] != -1)
        return t[i][j][z];
        // String key = i + " " + j + " " + isTrue;
        // if(map.containsKey(key))
        // return map.get(key);
        
        
        int ans = 0;
        
        for(int k = i+1 ; k <= j-1 ; k = k +2)
        {
            int lt = solve(s , i , k-1 , true);
            int lf = solve(s , i , k-1 , false);
            int rt = solve(s , k+1 , j , true);
            int rf = solve(s , k+1 , j , false);
            
            switch(s[k])
            {
                case '&' : 
                    if(isTrue == true)
                    ans += (lt * rt)% mod;
                    else 
                    ans +=  ( (lf*rt)% mod + (lf*rf)% mod + (lt*rf)% mod ) % mod;
                    break;
                
                case '|' :
                    if(isTrue == true)
                    ans += ( (lf*rt)% mod + (lt*rf)% mod + (lt*rt)% mod ) % mod;
                    else 
                    ans += (lf*rf) % mod;
                    break;
                    
                case '^' :
                    if(isTrue == true)
                    ans += ( (lt*rf)% mod + (lf*rt)% mod ) % mod;
                    else
                    ans += ( (lf*rf)% mod + (lt*rt)% mod ) % mod;
                    break;
            }
        
        }
        
        return t[i][j][z] = ans% mod;
    }
}