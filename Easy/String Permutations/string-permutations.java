//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        ArrayList<String> ans = new ArrayList<>();
        permute(S, ans , 0 , S.length() -1);
        Collections.sort(ans);
        return ans;
    }
    
    public void permute(String s , ArrayList<String> ans , int l , int r)
    {
        if(l == r)
        {
            ans.add(s);
            return;
        }
        
        for(int i = l ; i <= r ; i++)
        {
            s = swap(s , l , i);
            permute(s , ans , l+1 , r);
            s = swap(s , l , i);
        }
        return;
    }
    
    
    public String swap(String s , int i , int j)
    {
        char[] a = s.toCharArray();
        
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        
        
        return String.valueOf(a);
     }
	   
}
