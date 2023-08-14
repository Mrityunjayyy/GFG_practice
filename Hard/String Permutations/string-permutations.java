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
        StringBuilder sb = new StringBuilder(S);
        ArrayList<String> ans = new ArrayList<String>();
        solve(ans , sb , 0);
        
        Collections.sort(ans);
        return ans;
    }
    
    
    public void solve(ArrayList<String> ans , StringBuilder sb ,int x)
    {
        if(x == sb.length())
        { 
            String s = sb.toString();
            ans.add(s);
            return;
        }
        
        for(int i = x ; i < sb.length() ; i++)
        {
            sb = swap(sb ,i ,x);
            solve(ans , sb , x+1);
            sb = swap(sb ,i ,x);
        }
        return;
    }
    
    
    public StringBuilder swap(StringBuilder sb  , int i , int j)
    {
        char[] arr = sb.toString().toCharArray();
        
         char temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
         
         StringBuilder give = new StringBuilder();
         give.append(arr);
        return give;
    }
	   
}
 