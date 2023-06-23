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
        List<String> al = new ArrayList<String>();
        int n = S.length() -1;
        
        perm(al  , S , 0  , n);
        
        Set<String> set = new HashSet<String>(al);
        al.clear();
        al.addAll(set);
        
        
        
        String[] arr = new String[al.size()];
        arr = al.toArray(arr);
        
        Arrays.sort(arr);
        
        
        return Arrays.asList(arr);
        
    }
    
    
    public void perm( List<String> al  ,String s , int l , int r)
    { 
     
     if(l == r)
     { 
       al.add(new String(s));  
       return;
     }
     
     
     else
     { 
         for(int i = l ; i <= r ; i++)
         { 
             s = swap(s , i , l);
             perm(al , s , l+1 , r);
             
             s = swap(s,i,l);
         }
     }
    }
    
    
    
    public String swap(String str , int i , int j)
    { 
        char[] arr = str.toCharArray();
        
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return String.valueOf(arr);
    }
    
    
    
    
    
    
}