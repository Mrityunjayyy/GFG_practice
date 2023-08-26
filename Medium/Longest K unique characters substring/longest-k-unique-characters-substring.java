//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
      HashMap<Character , Integer> map = new HashMap<>();
      int l,r;
      l = r = 0;
      int n = s.length();
      int ans = -1;
      while(r < n)
      {
          map.put(s.charAt(r) , map.getOrDefault(s.charAt(r) ,0) +1);
          
          while(map.size() > k)
          {
              map.put(s.charAt(l) , map.getOrDefault(s.charAt(l) , 1) -1);
              if(map.get(s.charAt(l)) == 0)
              {
                  map.remove(s.charAt(l));
              }
              
              l++;
          }
          
          
          if(map.size() == k)
          {
              ans = Math.max(ans , r - l +1);
          }
          
          r++;
      }
      
      return ans;
    }
}