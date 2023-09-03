//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();//testcases
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int n,k;
		    //taking input n and k
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    //calling josephus() function
		    System.out.println(obj.josephus(n,k));
		    
		    
		}
		
	}
}


// } Driver Code Ends


class Solution
{ 
    int ans = -1;
   public int josephus(int n, int k)
    {
        ArrayList<Integer> al = new ArrayList();
        for(int i = 1 ; i <= n ; i++)
        {
            al.add(i);
        }
        
        --k;
        solve(al , k , 0);
        
        return ans;
    }
    
    public void solve(ArrayList<Integer> al , int k , int index)
    {
        if(al.size() == 1)
        {
            ans = al.get(0);
            return;
        }
        
        index = (index + k)%al.size();
        al.remove(index);
        solve(al , k , index);
        return;
        
    }

}

