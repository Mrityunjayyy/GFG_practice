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
       
       ArrayList<String> al = new ArrayList<String>();
       int n = S.length() -1 ;
       
       perm(al , S , 0 , n);
       
       
       Collections.sort(al);
       
       return al;
       
       
       
       
       
    }
    
    
    
    public void perm(ArrayList<String> al , String s , int l , int r)
    { 
        if(l ==r)
        { 
            
            al.add(new String(s));
            return;
            
        }
        
        else
        { 
            
            for(int i = l ; i <= r ; i++)
            { 
                s =    swap(s , i , l);
                perm(al , s , l +1 , r);
                
                s = swap(s , i , l);
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

