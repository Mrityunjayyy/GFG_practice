//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
      
       List<String> ans = new ArrayList<>();
       
       solve(S , 0 , ans);
       HashSet<String> set = new HashSet<String>(ans);
       ans.clear();
       ans.addAll(set);
       Collections.sort(ans);
       return ans;
       
    }
    
    public void solve(String s , int index ,List<String> ans)
    {
        if(index == s.length())
        {
            ans.add(s);
            return;
        }
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            s = swap(s , i , index);
            solve(s , index +1 , ans);
            s = swap(s , i , index);
        }
    }
    
    
    public String swap(String s , int i , int j)
    {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return new String(arr);
    }
}