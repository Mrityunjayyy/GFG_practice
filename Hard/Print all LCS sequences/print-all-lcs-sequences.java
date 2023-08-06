//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
            for(int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> all_longest_common_subsequences(String s, String t)
    {
        int m = s.length();
        int n = t.length();
        List<String>[][] dp = new ArrayList[m+1][n+1];

// initializing all the blocks with empty array list        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }


        dp(s , t , m , n , dp);
        
        HashSet<String> set = new HashSet<>();
        int max = dp[m][n].get(0).length();

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (String subseq : dp[i][j]) {
                    if (subseq.length() == max) {
                        set.add(subseq);
                    }
                }
            }
        }

        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
        
    }
    
    public void dp(String a , String b , int m , int n ,   List<String>[][] dp)
    {
      
       for (int i = 0; i <= m; i++) {
            dp[i][0].add(""); // Empty string is a subsequence of any string
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j].add(""); // Empty string is a subsequence of any string
        }
    
   for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    for (String subseq : dp[i - 1][j - 1]) {
                        dp[i][j].add(subseq + a.charAt(i - 1));
                    }
                } else {
                    if (dp[i - 1][j].get(0).length() > dp[i][j - 1].get(0).length()) {
                        dp[i][j].addAll(dp[i - 1][j]);
                    } else if (dp[i][j - 1].get(0).length() > dp[i - 1][j].get(0).length()) {
                        dp[i][j].addAll(dp[i][j - 1]);
                    } else {
                        dp[i][j].addAll(dp[i - 1][j]);
                        dp[i][j].addAll(dp[i][j - 1]);
                    }
                }

                // Remove duplicate subsequences at each cell
                dp[i][j] = new ArrayList<>(new HashSet<>(dp[i][j]));
            }
        }

    
   }
}