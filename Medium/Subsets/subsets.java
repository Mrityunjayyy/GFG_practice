//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    ArrayList<Integer> A = new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        A.add(arr[i]);
		        
		    }
		   
		   
		    
		    ArrayList <ArrayList<Integer>> res = new Solution().subsets(A);
		    for (int i = 0; i < res.size (); i++)
		    {
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		          System.out.print(res.get(i).get(j)+" ");
		        }
		        System.out.println();
		      
		    }
		    //System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        ArrayList<ArrayList<Integer>> ans = new  ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        solve(ans , A , al , 0);
        
        Collections.sort(ans , (a , b) -> 
        {
            int min = Math.min(a.size() , b.size());
            
            for(int i = 0 ; i < min ; i++)
            {
                int cmp = a.get(i).compareTo(b.get(i));
                if(cmp != 0)
                {
                  return cmp;   
                }
               
            }
            
            
            return Integer.compare(a.size() , b.size());
        });
      
        ans.add(0 , new ArrayList<Integer>());
        return ans;
    }
    
    
    public static void solve(ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> a , ArrayList<Integer> al, int index)
    {
        if(index  == a.size())
        { 
            if(al.size() > 0)
            ans.add(new ArrayList(al));
            
            return;
        }
        
        solve(ans , a , al , index +1);
         
         
         
        al.add(a.get(index));
        solve(ans , a , al, index +1);
        al.remove(al.size()-1);
        return;
    }
}